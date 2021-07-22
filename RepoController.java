package com.biclinical.bicconsole.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biclinical.bicconsole.bean.LoginDetail;
import com.biclinical.bicconsole.config.ApplicationProperties;
import com.biclinical.bicconsole.constants.UtilityConstants;
import com.biclinical.bicconsole.dto.ReportingPeriodMappingDTO;
import com.biclinical.bicconsole.exception.InvalidRequestException;
import com.biclinical.bicconsole.model.AdditionalConfig;
import com.biclinical.bicconsole.model.OrgMeasureSetMappingUpdate;
import com.biclinical.bicconsole.model.ReportingPeriod;
import com.biclinical.bicconsole.model.ReportingPeriodEditDetails;
import com.biclinical.bicconsole.model.ReportingPeriodMeasureSet;
import com.biclinical.bicconsole.model.ReportingPeriodOrganization;
import com.biclinical.bicconsole.model.ReportingPeriodPopulationFilter;
import com.biclinical.bicconsole.model.ReportingPeriodSourceDetails;
import com.biclinical.bicconsole.model.ReportingPeriodView;
import com.biclinical.bicconsole.model.ReportingPeriodViewPopup;
import com.biclinical.bicconsole.service.ReportingPeriodService;
import com.biclinical.bicconsole.util.Constants;
import com.biclinical.bicconsole.util.Validator;

@RestController
@RequestMapping("/reportingperiod/")
public class ReportingPeriodController {
	Logger logger = LoggerFactory.getLogger(ReportingPeriodController.class);

	@Autowired
	private ReportingPeriodService reportingPeriodService;
	
	@Autowired
	private HttpServletRequest request;

	@PostMapping("/additionalconfiglist")
	public ResponseEntity<Collection<AdditionalConfig>> getAllAddtionalConfigList() {
		try {
			List<AdditionalConfig> list = reportingPeriodService.listAdditionalConfig();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/populationfilter")
	public ResponseEntity<Collection<ReportingPeriodPopulationFilter>> getAllPopulationFilterList() {
		try {
			List<ReportingPeriodPopulationFilter> list = reportingPeriodService.listPopulationFilter();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/sourcedetails")
	public ResponseEntity<Collection<ReportingPeriodSourceDetails>> getAllSourceDetailsList() {
		try {
			List<ReportingPeriodSourceDetails> list = reportingPeriodService.listSourceDetails();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/checkReportingPeriodAvailability")
	public ResponseEntity<ReportingPeriodMappingDTO> checkReportingPeriodAvailability(
			@RequestBody ReportingPeriodMappingDTO runCode) {
		if (Validator.validateMesureSet(runCode.getName())) {
			throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.EMPTY_NULL_VALUES));
		}

		String status = reportingPeriodService.checkReportingPeriodAvailability(runCode.getName());
		runCode.setStatus(status);
		return ResponseEntity.ok(runCode);

	}

	@PostMapping("/reportinglist")
	public ResponseEntity<Collection<ReportingPeriodView>> getReportingPeriodList() {
		try {
			List<ReportingPeriodView> list = reportingPeriodService.listReportingPeriod();
			if (list != null) {
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/searchbyname")
	public ResponseEntity<Collection<ReportingPeriodViewPopup>> getReportingPeriodByName(
			@RequestBody ReportingPeriodMappingDTO dto) {
		try {
			if (Validator.validateMesureSet(dto.getName())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.EMPTY_NULL_VALUES));
			}
			List<ReportingPeriodViewPopup> list = reportingPeriodService.listReportingPeriodByName(dto.getName());

			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/organizationdetails")
	public ResponseEntity<Collection<ReportingPeriodOrganization>> getAllRPOrganizationList() {
		try {
			List<ReportingPeriodOrganization> list = reportingPeriodService.listReportingPeriodOrganization();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/measuresetdetails")
	public ResponseEntity<Collection<ReportingPeriodMeasureSet>> getAllRPMeasureSetList() {
		try {
			List<ReportingPeriodMeasureSet> list = reportingPeriodService.listReportingPeriodMeasureSet();
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/createReportingPeriod")
	public ResponseEntity<?> createReportingPeriod(@RequestBody ReportingPeriod rp) throws ParseException {

		LoginDetail loginDetail = (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
		try {

			if (Validator.validateReportingPeriodName(rp.getRunCode())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.INVALID_PEPORTING_PERIOD_NAME));
			}

			if (Validator.validateRPStartDate(rp.getReportingPeriodStartDate())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.START_DATE_EMPTY));
			}

			else if (Validator.validateRPEndDate(rp.getReportingPeriodEndDate())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.END_DATE_EMPTY));
			}

			else if (Validator.validateSourceDetails(rp.getSdCode())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.SD_CODE_EMPTY));
			}

			else if (Validator.validateProcessingFromDate(rp.getProcessingStartDate())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.PROCESSING_FROM_DATE_EMPTY));
			}

			else if (Validator.validateProcessingToDate(rp.getProcessingEndDate())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.PROCESSING_TO_DATE_EMPTY));
			}

			reportingPeriodService.createReportingPeriod(rp.getRunCode(), rp.getReportingPeriodStartDate(),
					rp.getReportingPeriodEndDate(), rp.getPfCode(), rp.getSdCode(), rp.getFrequencyType(),
					rp.getAdditionalConfigDetails(), rp.getProcessingStartDate(), rp.getProcessingEndDate(),
					rp.getPatientScope(), rp.getOrgMeasureMapping(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		 }
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/additionalConfigEdit")
	public ResponseEntity<Collection<AdditionalConfig>> getAllAddtionalConfigEditList(@RequestBody ReportingPeriod rp) {
		try {
			if (Validator.validateReportingPeriodName(rp.getRunCode())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.INVALID_PEPORTING_PERIOD_NAME));
			}
			List<AdditionalConfig> list = reportingPeriodService.listAdditionalConfigUpdate(rp.getRunCode());
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/orgMeasureSetMappingEdit")
	public ResponseEntity<Collection<OrgMeasureSetMappingUpdate>> getOrgMeasureSetMappingList(
			@RequestBody ReportingPeriod rp) {
		try {
			if (Validator.validateReportingPeriodName(rp.getRunCode())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.INVALID_PEPORTING_PERIOD_NAME));
			}
			List<OrgMeasureSetMappingUpdate> list = reportingPeriodService
					.listOrgMeasureSetMappingUpdate(rp.getRunCode());
			if (list != null)
				return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

			else
				return ResponseEntity.notFound().build();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/updateReportingPeriod")
	public ResponseEntity<?> updateReportingPeriod(@RequestBody ReportingPeriod rp) throws ParseException {
		LoginDetail loginDetail = (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
		try {

			if (Validator.validateReportingPeriodName(rp.getRunCode())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.INVALID_PEPORTING_PERIOD_NAME));
			}

			if (Validator.validateRPStartDate(rp.getReportingPeriodStartDate())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.START_DATE_EMPTY));
			}

			else if (Validator.validateRPEndDate(rp.getReportingPeriodEndDate())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.END_DATE_EMPTY));
			}

			else if (Validator.validateSourceDetails(rp.getSdCode())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.SD_CODE_EMPTY));
			}

			else if (Validator.validateProcessingFromDate(rp.getProcessingStartDate())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.PROCESSING_FROM_DATE_EMPTY));
			}

			else if (Validator.validateProcessingToDate(rp.getProcessingEndDate())) {
				throw new InvalidRequestException(
						ApplicationProperties.getProperty(Constants.PROCESSING_TO_DATE_EMPTY));
			}

			reportingPeriodService.updateReportingPeriod(rp.getRunCode(), rp.getReportingPeriodStartDate(),
					rp.getReportingPeriodEndDate(), rp.getPfCode(), rp.getSdCode(), rp.getFrequencyType(),
					rp.getAdditionalConfigDetails(), rp.getProcessingStartDate(), rp.getProcessingEndDate(),
					rp.getPatientScope(), rp.getOrgMeasureMapping(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@PostMapping("/reportingPeriodEditDetails")
	public ResponseEntity<Collection<ReportingPeriodEditDetails>> reportingPeriodDetailsList(
			@RequestBody ReportingPeriod dto) {
		try {
			if (Validator.validateMesureSet(dto.getRunCode())) {
				throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.EMPTY_NULL_VALUES));
			}
			List<ReportingPeriodEditDetails> list = reportingPeriodService
					.listReportingPeriodEditDetails(dto.getRunCode());

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
