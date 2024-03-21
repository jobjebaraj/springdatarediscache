package com.spring.study.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {


    @Bean
    public String getDeptWithId() {
        return "HR";
    }
}
