package com.abc.affiliate.dataadapter.service;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;

import com.abc.affiliate.dataadapter.domain.common.ProcessIdStatus;

public interface ProductService {

	public void upload(String processId, FileItemIterator itemIterator) throws Exception;
	public ProcessIdStatus getStatus(String processId);

}
