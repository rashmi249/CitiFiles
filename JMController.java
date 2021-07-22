package com.biclinical.bicconsole.controller;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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

import com.biclinical.bicconsole.bean.LoginDetail;
import com.biclinical.bicconsole.constants.UtilityConstants;
import com.biclinical.bicconsole.dto.ScheduleStatus;
import com.biclinical.bicconsole.exception.RestClientException;
import com.biclinical.bicconsole.model.BICConsoleJobModel;
import com.biclinical.bicconsole.model.DeleteJobSchedule;
import com.biclinical.bicconsole.model.EnableDisableJobSchedule;
import com.biclinical.bicconsole.model.JobExecutionPopUp;
import com.biclinical.bicconsole.model.JobSchedule;
import com.biclinical.bicconsole.model.JobScheduleCQMStatus;
import com.biclinical.bicconsole.model.JobScheduleDetails;
import com.biclinical.bicconsole.model.JobScheduleExecute;
import com.biclinical.bicconsole.model.JobSchedulePopUpDetails;
import com.biclinical.bicconsole.model.JobSchedulePopUpPriority;
import com.biclinical.bicconsole.model.JobScheduleUpdate;
import com.biclinical.bicconsole.model.JobSchedulingDateTime;
import com.biclinical.bicconsole.model.JobSchedulingJobStatusList;
import com.biclinical.bicconsole.model.JobSchedulingSteps;
import com.biclinical.bicconsole.model.RunConfigPriority;
import com.biclinical.bicconsole.model.ScheduleDetails;
import com.biclinical.bicconsole.model.SchedulePopUp;
import com.biclinical.bicconsole.service.JobScheduleService;

@RestController
@RequestMapping("/jobMonitoring/")
public class JobMonitoringController {

	Logger logger = LoggerFactory.getLogger(JobMonitoringController.class);

	@Autowired
	private JobScheduleService jobScheduleService;

	@Autowired
	private HttpServletRequest request;

	/*
	 * @Autowired private JobStatusMap jobStatusMap;
	 */
	@PostMapping("/createJobSchedule")
	public ResponseEntity<?> createJobSchedule(@RequestBody JobSchedule jobSchedule) {
		try {
			logger.info("inside createJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.createJobSchedule(jobSchedule.getScheduleDetails(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/updateJobSchedule")
	public ResponseEntity<?> updateJobSchedule(@RequestBody JobScheduleUpdate jobScheduleupdate) {
		try {
			logger.info("inside updateJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.updateJobSchedule(jobScheduleupdate.getScheduleDetails(),
					jobScheduleupdate.getScheduleName(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/executeJobSchedule")
	public ResponseEntity<?> executeJobSchedule(@RequestBody JobScheduleExecute jobScheduleExecute)
			throws ParseException {
		try {
			logger.info("inside executeJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.excuteJobSchedule(jobScheduleExecute.getJobName(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/pauseJobSchedule")
	public ResponseEntity<?> pauseJobSchedule(@RequestBody JobScheduleExecute jobScheduleExecute)
			throws ParseException {
		try {
			logger.info("inside pauseJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.pauseJobSchedule(jobScheduleExecute.getJobName(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/resumeJobSchedule")
	public ResponseEntity<?> resumeJobSchedule(@RequestBody JobScheduleExecute jobScheduleExecute)
			throws ParseException {
		try {
			logger.info("inside resumeJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.resumeJobSchedule(jobScheduleExecute.getJobName(), loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/updateRunConfigPriority")
	public ResponseEntity<?> updateRunConfigPriority(@RequestBody RunConfigPriority runConfigPriority)
			throws ParseException {
		try {
			logger.info("inside updateRunConfigPriority()");
			jobScheduleService.updateRunConfigPriority(runConfigPriority.getRunConfigPriority());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/updateJobStatus")
	public ResponseEntity<?> updateJobStatus(@RequestBody EnableDisableJobSchedule enableDisableJobSchedule)
			throws ParseException {
		try {
			logger.info("inside updateJobStatus()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.updateJobStatus(enableDisableJobSchedule.getJobName(),
					enableDisableJobSchedule.getScheduleName(), enableDisableJobSchedule.getScheduleStatus(),
					loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/deleteJobSchedule")
	public ResponseEntity<?> deleteJobSchedule(@RequestBody DeleteJobSchedule deleteJobSchedule) throws ParseException {
		try {
			logger.info("inside deleteJobSchedule()");
			LoginDetail loginDetail = (LoginDetail) request
					.getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			jobScheduleService.deleteJobSchedule(deleteJobSchedule.getJobName(), deleteJobSchedule.getScheduleName(),
					loginDetail.getUsername());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/getDateTime")
	public ResponseEntity<Collection<JobSchedulingDateTime>> getjobschedulingDateTimeList() {
		try {
			logger.info("inside getjobschedulingDateTimeList()");
			List<JobSchedulingDateTime> list = jobScheduleService.listJobSchedulingDateTime();

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

	@PostMapping("/cqmStatus")
	public ResponseEntity<Collection<JobScheduleCQMStatus>> getlistJobScheduleCQMStatus() {
		try {
			logger.info("inside getlistJobScheduleCQMStatus()");
			List<JobScheduleCQMStatus> list = jobScheduleService.listJobScheduleCQMStatus();

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

	@PostMapping("/schedulePopUp")
	public ResponseEntity<Collection<JobSchedulePopUpDetails>> getlistJobSchedulePopUpDetails(
			@RequestBody SchedulePopUp schedulePopUp) {
		try {
			logger.info("inside getlistJobSchedulePopUpDetails()");
			List<JobSchedulePopUpDetails> list = jobScheduleService
					.listJobSchedulePopUpDetails(schedulePopUp.getJobName());
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

	@PostMapping("/schedulePriority")
	public ResponseEntity<Collection<JobSchedulePopUpPriority>> getlistJobSchedulePopUpPriority(
			@RequestBody SchedulePopUp schedulePopUp) {
		try {
			logger.info("inside getlistJobSchedulePopUpPriority()");
			List<JobSchedulePopUpPriority> list = jobScheduleService
					.listJobSchedulePopUpPriority(schedulePopUp.getJobName());
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

	@PostMapping("/scheduleStatus")
	public ResponseEntity<Collection<JobSchedulingJobStatusList>> getlistJobSchedulingJobSteps() {
		try {
			logger.info("inside getlistJobSchedulingJobSteps()");
			List<JobSchedulingJobStatusList> statusList = jobScheduleService.listJobSchedulingJobStatus();
			List<JobSchedulingSteps> stepsList = jobScheduleService.listJobSchedulingJobSteps();

			if (statusList != null && !statusList.isEmpty()) {
				for (JobSchedulingJobStatusList status : statusList) {
					if (status.getId() != null) {
						List<JobSchedulingSteps> result = stepsList.stream()
								.filter(steps -> steps.getMasterJobId() == status.getId()).collect(Collectors.toList());
						status.setSteps(result);
					}
				}
			}

			if (statusList != null) {
				return ResponseEntity.ok(statusList.stream().collect(Collectors.toList()));

			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@PostMapping("/jobScheduleDetails")
	public ResponseEntity<Collection<JobScheduleDetails>> getlistJobScheduleDetails(
			@RequestBody JobScheduleDetails jobScheduleDetails) {
		try {
			logger.info("inside getlistJobScheduleDetails()");
			List<JobScheduleDetails> list = jobScheduleService.listJobScheduleDetails(jobScheduleDetails.getJobName(),
					jobScheduleDetails.getScheduleName());

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

	@PostMapping("/jobExecutionPopUp")
	public ResponseEntity<Collection<JobExecutionPopUp>> getJobExecutionPopUp(
			@RequestBody JobScheduleExecute jobScheduleExecute) {
		try {
			logger.info("inside getJobExecutionPopUp()");
			List<JobExecutionPopUp> list = jobScheduleService.jobExecutionPopUp(jobScheduleExecute.getJobName());

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

	@PostMapping("/hasScheduleName")
	public ResponseEntity<ScheduleStatus> hasScheduleName(@Valid @RequestBody ScheduleDetails scheduleDetails) {
		logger.info("inside hasScheduleName()");
		ScheduleStatus sts = new ScheduleStatus();
		String status = jobScheduleService.listJobScheduleNameStatus(scheduleDetails.getJobName(),
				scheduleDetails.getScheduleName());
		sts.setStatus(status);
		return ResponseEntity.ok(sts);

	}

	@PostMapping("/callBICConsoleJob")
	public ResponseEntity<List<?>> callBICConsoleJob(@RequestBody BICConsoleJobModel bicConsoleJobModel)
			throws RestClientException {
		logger.info("inside callBICConsoleJob()");
		try {
			LoginDetail loginDetail = (LoginDetail) request
                    .getAttribute(UtilityConstants.REQUEST_ATTRIBUTE_LOGIN_DETAIL);
			bicConsoleJobModel.setUserName(loginDetail.getUsername());
			return jobScheduleService.callBICConsoleJobMonitor(bicConsoleJobModel);
		} catch (Exception e) {
			logger.error("Error while calling callBICConsoleJob" + e.getMessage(), e);
			e.printStackTrace();
			throw new RestClientException(e.getMessage());
		}
	}
}
