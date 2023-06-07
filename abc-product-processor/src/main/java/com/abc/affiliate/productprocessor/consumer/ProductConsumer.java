package com.abc.affiliate.productprocessor.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.abc.affiliate.productprocessor.dto.common.ProcessIdStatus;
import com.abc.affiliate.productprocessor.dto.product.Result.Products.Product;
import com.abc.affiliate.productprocessor.service.ProductService;

@Component
public class ProductConsumer {
	
    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);
    
    @Autowired
    @Qualifier("productServiceImpl")
    public ProductService productService;
    
    @Autowired
    private RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus;
    
    public static final String HASH_KEY_NAME = "PRODUCT-UPLOAD";
    
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "productListener" )
    public void productConsumer(Product product) {
        logger.info("Product consume => {}", product.getEan());
        
        try { 
        	
        	productService.save(product);
        	
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
}