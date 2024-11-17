package com.example.uber.app.cofigs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigs {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
