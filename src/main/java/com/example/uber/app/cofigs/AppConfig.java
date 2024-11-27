package com.example.uber.app.cofigs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {
    @Value("${spring.distance.base-url}")
    private String BASE_URL;
    @Bean
    public RestClient restClient(){
        return RestClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }


}
