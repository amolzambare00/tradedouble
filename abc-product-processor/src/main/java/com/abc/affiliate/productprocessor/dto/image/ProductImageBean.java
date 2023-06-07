package com.abc.affiliate.productprocessor.dto.image;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductImageBean {

	private long id;
	private int height;
	private int width;
	private String value;
	private long productId;
	private String productName;
	
}
