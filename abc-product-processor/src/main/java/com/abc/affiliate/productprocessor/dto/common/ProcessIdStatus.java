package com.abc.affiliate.productprocessor.dto.common;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessIdStatus implements Serializable {
	
	private String processId;
	private ProcessStatus status;
	private Integer totalRecords;
	private Integer completedRecords;
	private Map<String, String> errorMsg;
	
}
