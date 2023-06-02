package com.abc.affiliate.dataadapter.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.abc.affiliate.dataadapter.dto.common.ProcessIdStatus;
import com.abc.affiliate.dataadapter.dto.common.ProcessStatus;
import com.abc.affiliate.dataadapter.service.ProductService;

@Service
@Qualifier("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
	
	@Autowired
    private RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus;
    
    public static final String HASH_KEY_NAME = "PRODUCT-UPLOAD";

    
	@Override
	public void upload(String processId, FileItemIterator itemIterator) throws Exception {
		while (itemIterator.hasNext()) {
            FileItemStream item = itemIterator.next();
            if(item.isFormField()) {
                continue;
            }
            upload(processId, item);
        }
	}

	private void upload(String processId, FileItemStream item) throws Exception {
        var fileName = item.getName();
        var type = item.getContentType();
        var ins = item.openStream();
        String tmpdir = System.getProperty("java.io.tmpdir");
        var destination = new File(tmpdir, String.format("%s-%s", processId, fileName));
        var outs = new FileOutputStream(destination);

        IOUtils.copy(ins, outs);
        ins.close();
        outs.close();
        
        LOG.info("Process {} with type {}", fileName, type);
        
        /* Store in redis */
        redisTemplateProcessIdStatus.opsForHash().put(HASH_KEY_NAME, processId, ProcessIdStatus.builder()
        		.processId(processId).completedRecords(0)
        		.status(ProcessStatus.New)
        		.totalRecords(0)
        		.build());
        
        JobParameters jobParameters = new JobParametersBuilder()
        		.addString("fileName", destination.getAbsolutePath())
				.addString("processId", processId)
                .addDate("date", new Date())
                .addLong("time",System.currentTimeMillis()).toJobParameters();
		
		JobExecution execution = jobLauncher.run(job, jobParameters);
		System.out.println("STATUS :: "+execution.getStatus());
        
		
    }
	
	@Override
	public ProcessIdStatus getStatus(String processId) {
		ProcessIdStatus processIdStatus = (ProcessIdStatus) redisTemplateProcessIdStatus.opsForHash().get(HASH_KEY_NAME, processId);
		if (processIdStatus != null && (processIdStatus.getStatus().equals(ProcessStatus.Completed) || processIdStatus.getStatus().equals(ProcessStatus.Canceled))) {
			//redisTemplateProcessIdStatus.opsForHash().delete(HASH_KEY_NAME, processId);
		}
		return processIdStatus;
	}
	
}
