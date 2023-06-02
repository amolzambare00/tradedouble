package com.abc.affiliate.dataadapter.batch.listener;

import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.abc.affiliate.dataadapter.dto.common.ProcessIdStatus;
import com.abc.affiliate.dataadapter.dto.common.ProcessStatus;

@Component
public class ProductCountListener implements ChunkListener {

	public static final String HASH_KEY_NAME = "PRODUCT-UPLOAD";
	
	@Autowired
	private RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus;

	@Override
	public void beforeChunk(ChunkContext context) {

	}

	@Override
	public void afterChunk(ChunkContext context) {
		int readCount = context.getStepContext().getStepExecution().getReadCount();
		int writeCount = context.getStepContext().getStepExecution().getWriteCount();
		String processId = (String) context.getStepContext().getJobParameters().get("processId");
		ProcessIdStatus processIdStatus = (ProcessIdStatus) redisTemplateProcessIdStatus.opsForHash().get(HASH_KEY_NAME, processId);
		if (processIdStatus == null) {
			processIdStatus = ProcessIdStatus.builder().build();
		}
		processIdStatus.setProcessId(processId);
		processIdStatus.setStatus(ProcessStatus.Processing);
		processIdStatus.setCompletedRecords(writeCount);
		processIdStatus.setTotalRecords(readCount);
		
		redisTemplateProcessIdStatus.opsForHash().put(HASH_KEY_NAME, processId, processIdStatus);
		System.out.println("ItemCount: " + readCount);
	}

	@Override
	public void afterChunkError(ChunkContext context) {

	}
}
