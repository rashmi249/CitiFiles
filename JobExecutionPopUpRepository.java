package com.biclinical.bicconsole.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.biclinical.bicconsole.model.JobExecutionPopUp;

@Repository
public interface JobExecutionPopUpRepository extends JpaRepository<JobExecutionPopUp, String>{

	@Query(value = "{call usp_BICJobStatusScheduling(:Operator, :DisplayJobName, :SchDetails, :SchName, :SchStatus, :IntServer, :RunConfig_priority)}", nativeQuery = true)
	 List<JobExecutionPopUp> jobExecutionPopUp(@Param("Operator") String Operator,
			 @Param("DisplayJobName") String DisplayJobName,
			 @Param("SchDetails") String SchDetails,
			 @Param("SchName") String SchName,
			 @Param("SchStatus") Integer SchStatus,
			 @Param("IntServer") String IntServer,
			 @Param("RunConfig_priority") String RunConfig_priority);
}
