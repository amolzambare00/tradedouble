package com.abc.affiliate.productprocessor.service;

import java.util.List;

import com.abc.affiliate.productprocessor.dto.image.ProductImageBean;
import com.abc.affiliate.productprocessor.dto.product.ProductImage;

public interface ProductImageService {

	public List<com.abc.affiliate.productprocessor.entity.ProductImage> saveAll(com.abc.affiliate.productprocessor.entity.Product product, List<ProductImage> products);
	public List<ProductImageBean> getImagesByProductId(Long productId);
	
}
