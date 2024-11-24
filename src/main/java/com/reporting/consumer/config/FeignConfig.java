package com.reporting.consumer.config;

import com.reporting.consumer.dto.AuthRequest;
import com.reporting.consumer.dto.AuthResponse;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

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
                AuthResponse response = Optional.ofNullable(restTemplate.postForObject(authServiceUrl, new AuthRequest(email, password), AuthResponse.class))
                        .orElseThrow(() -> new RuntimeException("Authentication failed"));
                FeignJWTHolder.setToken(response.getToken());
            }
            template.header("Authorization", FeignJWTHolder.getToken());
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}