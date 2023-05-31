package com.abc.affiliate.dataadapter.domain.common;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProcessIdStatus {
	
	private String processId;
	private ProcessStatus status;
	private Integer totalRecords;
	private Integer completedRecords;
	private Map<String, String> errorMsg;
	
}
