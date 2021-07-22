/**
 * 
 */
package com.biclinical.bicconsole.controller;

import static com.biclinical.bicconsole.util.Constants.MEASURESETS_DUPLICATE_NAME;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biclinical.bicconsole.bean.LoginDetail;
import com.biclinical.bicconsole.constants.UtilityConstants;
import com.biclinical.bicconsole.dto.MeasureQuery;
import com.biclinical.bicconsole.dto.MeasuresSetsMappingDTO;
import com.biclinical.bicconsole.dto.StatusMeasureSets;
import com.biclinical.bicconsole.exception.InvalidRequestException;
import com.biclinical.bicconsole.model.ClinicalMeasureClassification;
import com.biclinical.bicconsole.model.MeasureSetMeasureType;
import com.biclinical.bicconsole.model.MeasureSetProgram;
import com.biclinical.bicconsole.model.MeasureSetRuleCategory;
import com.biclinical.bicconsole.model.MeasureSetRuleType;
import com.biclinical.bicconsole.model.MeasureSets;
import com.biclinical.bicconsole.model.ViewMeasureSets;
import com.biclinical.bicconsole.model.ViewPopupMeasureSet;
import com.biclinical.bicconsole.service.MeasureSetsService;
import com.biclinical.bicconsole.util.Constants;
import com.biclinical.bicconsole.util.Validator;

@RestController
@RequestMapping("/measuresets/")
public class MeasureSetsController {

	Logger logger = LoggerFactory.getLogger(MeasureSetsController.class);

	@Autowired
	private MeasureSetsService measureSetsService;
	
	@Autowired
	private HttpServletRequest request;

	@PostMapping("/create")
    public ResponseEntity<?> createMeasureSets(@Valid @RequestBody MeasureSets measureset) {
        try {
            LoginDetail loginDetail = (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
            measureSetsService.createMeasureSet(measureset.getMeasureSetName(), loginDetail.getUsername());
            logger.info(HttpStatus.CREATED + " " + measureset.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (DataIntegrityViolationException dex) {
            return new ResponseEntity<>(MEASURESETS_DUPLICATE_NAME, HttpStatus.BAD_REQUEST);
        }
    }

	@PostMapping("/hasMeasureSet")
	public ResponseEntity<StatusMeasureSets> hasMeasureSet(@Valid @RequestBody MeasureSets measureset) {
		StatusMeasureSets sms = new StatusMeasureSets();
		String status = measureSetsService.hasMeasureSet(measureset.getMeasureSetName());
		sms.setStatus(status);
		return ResponseEntity.ok(sms);

	}

	@PostMapping("/addMeasures")
	public ResponseEntity<?> addMeasuresMapping(@Valid @RequestBody MeasuresSetsMappingDTO dto) {

		try {
			LoginDetail loginDetail = (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			measureSetsService.addMeasuresMappings(dto.getMeasureSetsName(),
					dto.getMeasures().stream().collect(Collectors.joining("|")), loginDetail.getUsername());

			logger.info(HttpStatus.CREATED + " measures count : " + dto.getMeasures().size());
			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (org.springframework.dao.DataIntegrityViolationException dex) {
			return new ResponseEntity<>("Duplicate Measures constraint", HttpStatus.BAD_REQUEST);
			// throw new MeasureSetsException(ex.getMessage());
		}
	}

	@PostMapping("/cmckeyvaluelist")
	public ResponseEntity<Collection<ClinicalMeasureClassification>> listCMCKeyValue() {

		List<ClinicalMeasureClassification> list = measureSetsService.listCMCKeyValue();

		if (list != null)
			return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping("/clinicalMeasureValues")
	public ResponseEntity<Collection<String>> clinicalMeasureValues() {
		List<String> list = measureSetsService.clinicalMeasureValues();
		Optional<List<String>> opl = Optional.ofNullable(list);

		if (opl.isPresent())
			return ResponseEntity.ok(list.stream().collect(Collectors.toList()));
		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping("/updatemeasuresmapping")
	public ResponseEntity<String> updateMeasureSet(@RequestBody MeasureQuery measureQuery) {

		LoginDetail loginDetail = (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
		if (Validator.validateMesureSet(measureQuery.getMeasureSetName())
				|| Validator.isEmptyListForClinicaMeasureId(measureQuery.getClinicalMeasureIdList())
				|| Validator.isEmptyString(loginDetail.getUsername())) {
			throw new InvalidRequestException(Constants.EMPTY_NULL_VALUES);
		}

		try {
			measureSetsService.updateMeasureSet(measureQuery,loginDetail.getUsername());
			return ResponseEntity.status(HttpStatus.OK).body(null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/list")
	public ResponseEntity<Collection<ViewMeasureSets>> getAllMeasureSets() {
		try {
			List<ViewMeasureSets> list = measureSetsService.listMeasureSet();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/search/")
	public ResponseEntity<Collection<ViewPopupMeasureSet>> getMeasureSetsByName(
			@RequestBody MeasuresSetsMappingDTO dto) {
		try {
			if (Validator.validateMesureSet(dto.getMeasureSetsName())) {
				throw new InvalidRequestException(Constants.EMPTY_NULL_VALUES);
			}
			List<ViewPopupMeasureSet> list = measureSetsService.listMeasuresByMeasureSets(dto.getMeasureSetsName());

			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/listrulecategory")
	public ResponseEntity<Collection<MeasureSetRuleCategory>> getRuleCategory() {
		try {
			List<MeasureSetRuleCategory> list = measureSetsService.listRuleCategory();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/listprogram")
	public ResponseEntity<Collection<MeasureSetProgram>> getProgram() {
		try {
			List<MeasureSetProgram> list = measureSetsService.listProgram();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/listruletype")
	public ResponseEntity<Collection<MeasureSetRuleType>> getRuleType() {
		try {
			List<MeasureSetRuleType> list = measureSetsService.listRuleType();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/listmeasuretype")
	public ResponseEntity<Collection<MeasureSetMeasureType>> getMeasureType() {
		try {
			List<MeasureSetMeasureType> list = measureSetsService.listMeasureType();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}
}
