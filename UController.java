/**
 * 
 */
package com.biclinical.bicconsole.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biclinical.bicconsole.bean.LoginDetail;
import com.biclinical.bicconsole.constants.Auth2Constants;
import com.biclinical.bicconsole.constants.UtilityConstants;
import com.biclinical.bicconsole.exception.UamException;
import com.biclinical.bicconsole.service.UamService;


/**
 * @author RajitkumarV
 *
 */

@RestController
@RequestMapping("/uam/")
public class UamController {

	Logger logger = LoggerFactory.getLogger(UamController.class);

	@Autowired
	private UamService uamService;

	@Autowired
	private HttpServletRequest request;

	@PostMapping(value = "/getUserDetail", produces = { "application/json" })
	public LoginDetail getUserDetail() {
		logger.debug("Inside UamController.getUserDetail()");
		return (LoginDetail) request.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
	}

	@PostMapping(value = "/getConfig", produces = { "application/json" })
	public String getConfig() throws UamException {
		logger.debug("Inside UamController.getConfig()");
		return uamService.getUAMConfig(request.getHeader(Auth2Constants.HEADER_APIKEY));
	}
}
