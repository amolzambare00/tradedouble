package com.abc.affiliate.productprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ProductprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductprocessorApplication.class, args);
	}

}
