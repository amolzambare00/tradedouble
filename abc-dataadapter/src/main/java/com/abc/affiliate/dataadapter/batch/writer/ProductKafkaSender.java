package com.abc.affiliate.dataadapter.batch.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

import com.abc.affiliate.dataadapter.dto.product.Result.Products.Product;


public class ProductKafkaSender implements ItemWriter<Product> {

	@Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;
    
    @Value("${spring.kafka.template.default-topic}")
    private String topic;
    
    @Override
    public void write(List<? extends Product> products) throws Exception {
        for (Product product : products) {
            kafkaTemplate.send(topic, product.getEan(), product);
        }
        System.out.println("Message sent to kafka ");
        
    }
}
