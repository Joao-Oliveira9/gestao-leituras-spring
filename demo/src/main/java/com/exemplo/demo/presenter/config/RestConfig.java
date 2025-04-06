package com.exemplo.demo.presenter.config;

import com.exemplo.demo.presenter.rest.AddLeituraController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
public class RestConfig {

    @Bean
    public AddLeituraController addLeituraController(){
        return new AddLeituraController();
    }
}
