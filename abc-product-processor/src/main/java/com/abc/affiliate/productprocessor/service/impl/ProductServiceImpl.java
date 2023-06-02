package com.abc.affiliate.productprocessor.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.abc.affiliate.productprocessor.dto.common.ProcessIdStatus;
import com.abc.affiliate.productprocessor.service.ProductService;

@Service
@Qualifier("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    
	@Autowired
    private RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus;
    
    public static final String HASH_KEY_NAME = "PRODUCT-UPLOAD";
    
	
	
}
