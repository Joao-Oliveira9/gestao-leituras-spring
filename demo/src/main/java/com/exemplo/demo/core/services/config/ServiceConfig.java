package com.exemplo.demo.core.services.config;

import com.exemplo.demo.core.domain.usecases.AddLeituraUseCase;
import com.exemplo.demo.core.services.AddLeituraService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AddLeituraUseCase addLeituraUseCase(){
        return new AddLeituraService();
    }
}
