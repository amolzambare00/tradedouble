package com.abc.affiliate.dataadapter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableBatchProcessing
@EnableKafka
public class DataadapterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataadapterApplication.class, args);
	}
	
}
