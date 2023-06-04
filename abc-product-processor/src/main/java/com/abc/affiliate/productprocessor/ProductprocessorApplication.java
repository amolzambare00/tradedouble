package com.abc.affiliate.productprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.kafka.annotation.EnableKafka;

import com.abc.affiliate.productprocessor.audit.AuditorAwareImpl;

@SpringBootApplication
@EnableKafka
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class ProductprocessorApplication {

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductprocessorApplication.class, args);
	}

}
