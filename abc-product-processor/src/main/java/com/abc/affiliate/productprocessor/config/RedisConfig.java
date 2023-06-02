package com.abc.affiliate.productprocessor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.abc.affiliate.productprocessor.dto.common.ProcessIdStatus;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {
	
	@Value("${redis.hostname}")
    private String redisHostName;

    @Value("${redis.port}")
    private int redisPort;
    
	@Bean
    JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration(redisHostName, redisPort);
        return new JedisConnectionFactory(redisConfiguration);
    }
	
    @Bean
    public RedisTemplate<String, ProcessIdStatus> redisTemplateProcessIdStatus(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, ProcessIdStatus> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

}
