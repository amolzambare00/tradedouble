package com.abc.affiliate.dataadapter.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

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
import org.springframework.stereotype.Service;

import com.abc.affiliate.dataadapter.domain.common.ProcessIdStatus;
import com.abc.affiliate.dataadapter.service.ProductService;

@Service
@Qualifier("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;
    
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
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
