package com.abc.affiliate.dataadapter.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.abc.affiliate.dataadapter.dto.common.ProcessIdStatus;
import com.abc.affiliate.dataadapter.dto.common.ProcessStatus;

@Component
public class ProductJobExecutionListener implements JobExecutionListener {

    Logger logger = LoggerFactory.getLogger(ProductJobExecutionListener.class);
    
    public static final String HASH_KEY_NAME = "PRODUCT-UPLOAD";
	
	@Autowired
	private RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus;
	
	@Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Called beforeJob().");
    }
    
    @Override
    public void afterJob(JobExecution jobExecution) {
    	String processId = jobExecution.getJobParameters().getString("processId");
    	ProcessIdStatus processIdStatus = (ProcessIdStatus) redisTemplateProcessIdStatus.opsForHash().get(HASH_KEY_NAME, processId);
		if (processIdStatus == null) {
			processIdStatus = ProcessIdStatus.builder().build();
		}

		processIdStatus.setProcessId(processId);
        if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
        	processIdStatus.setStatus(ProcessStatus.Completed);
        	
        } else if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
        	processIdStatus.setStatus(ProcessStatus.Canceled);
        }
		
		redisTemplateProcessIdStatus.opsForHash().put(HASH_KEY_NAME, processId, processIdStatus);
    	
		
        logger.info("Called afterJob().");
    }
}