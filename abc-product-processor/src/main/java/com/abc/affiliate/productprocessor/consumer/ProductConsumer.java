package com.abc.affiliate.productprocessor.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.abc.affiliate.productprocessor.dto.product.Result.Products.Product;

@Component
public class ProductConsumer {
	
    private static final Logger logger = LoggerFactory.getLogger(ProductConsumer.class);
    
    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "productListener" )
    public void productConsumer(Product product) {
        logger.info("Product consume => {}", product.getEan());
        
        
        
    }

    
}