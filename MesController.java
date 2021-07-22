/**
 * 
 */
package com.biclinical.bicconsole.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biclinical.bicconsole.config.ApplicationProperties;
import com.biclinical.bicconsole.dto.CMCSearch;
import com.biclinical.bicconsole.dto.MeasureQuery;
import com.biclinical.bicconsole.exception.InvalidRequestException;
import com.biclinical.bicconsole.model.Measures;
import com.biclinical.bicconsole.service.MeasuresService;
import com.biclinical.bicconsole.util.Constants;
import com.biclinical.bicconsole.util.Validator;

/**
 * @author RajitkumarV
 *
 */

@RestController
@RequestMapping("/measures/")
public class MeasuresController {

	Logger logger = LoggerFactory.getLogger(MeasuresController.class);

	@Autowired
	private MeasuresService measuresService;

	@PostMapping("/list")
	public ResponseEntity<?> listMeasure() throws Exception {

		List<Measures> list = measuresService.listMeasures();

		if (list != null)
			return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping("/cmcsearch")
	public ResponseEntity<Collection<Measures>> searchMeasures(@Valid @RequestBody CMCSearch search) {

		List<Measures> list = measuresService.searchMeasures(search);

		if (list != null)
			return ResponseEntity.ok(list.stream().collect(Collectors.toList()));

		else
			return ResponseEntity.notFound().build();

	}

	@PostMapping("/listmeasuresbysetname")
	public ResponseEntity<Collection<Measures>> listMeasuresBySet(@RequestBody MeasureQuery measureQuery) {

		if (Validator.validateMesureSet(measureQuery.getMeasureSetName())
				|| Validator.isEmptyString(measureQuery.getCmcKeys())
				|| Validator.isEmptyString(measureQuery.getCmcValues())) {
			throw new InvalidRequestException(ApplicationProperties.getProperty(Constants.EMPTY_NULL_VALUES));
		}
		try {
			List<Measures> measures = measuresService.listMeasuresBySet(measureQuery);
			return ResponseEntity.status(HttpStatus.OK).body(measures);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
