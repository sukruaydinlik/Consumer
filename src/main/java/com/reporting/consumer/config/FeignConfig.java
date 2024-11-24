package com.reporting.consumer.config;

import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FeignConfig {

    @Value("${feign.client.email}")
    private String email;

    @Value("${feign.client.password}")
    private String password;

    @Value("${feign.client.auth.url}")
    private String authServiceUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RequestInterceptor requestInterceptor(RestTemplate restTemplate) {
        return template -> {
            String token = FeignJWTHolder.getToken();
            if (token == null) {
                token = restTemplate.postForObject(authServiceUrl, new AuthRequest(email, password), String.class);
                FeignJWTHolder.setToken(token);
            }
            template.header("Authorization", "Bearer " + token);
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}