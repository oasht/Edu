package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
    @Bean
    public String hello() {
        return "Hello world";
    }
}
