package com.abc.affiliate.productprocessor.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.abc.affiliate.productprocessor.converters.ProductImageConverter;
import com.abc.affiliate.productprocessor.dto.image.ProductImageBean;
import com.abc.affiliate.productprocessor.dto.product.ProductImage;
import com.abc.affiliate.productprocessor.repository.ProductImageRepository;
import com.abc.affiliate.productprocessor.service.ProductImageService;

@Service
@Qualifier("productImageServiceImpl")
public class ProductImageServiceImpl implements ProductImageService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductImageServiceImpl.class);
    
    @Autowired
    public ProductImageRepository productImageRepository;
    
    @Autowired
    public ProductImageConverter converter;
    
	@Override
	@Transactional
	public List<com.abc.affiliate.productprocessor.entity.ProductImage> saveAll(com.abc.affiliate.productprocessor.entity.Product product, List<ProductImage> products) {
		List<com.abc.affiliate.productprocessor.entity.ProductImage> images = new ArrayList<>();
		if (products != null && products.size() > 0) {
			for (ProductImage productImageDto : products) {
				com.abc.affiliate.productprocessor.entity.ProductImage productImage = com.abc.affiliate.productprocessor.entity.ProductImage.builder()
					.height(productImageDto.getHeight())
					.product(product)
					.value(productImageDto.getValue())
					.width(productImageDto.getWidth())
					.build();
				
				images.add(productImageRepository.save(productImage));
			}
		}
		return images;
	}

	@Override
	@Transactional
	public List<ProductImageBean> getImagesByProductId(Long productId) {
		return StreamSupport.stream(
                	Spliterators.spliteratorUnknownSize(productImageRepository.findByProduct_Id(productId).iterator(), Spliterator.ORDERED), false)
                	.map(def -> converter.convert(def)).collect(Collectors.toList());
		
	}
	
}
