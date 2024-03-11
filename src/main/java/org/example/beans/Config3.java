package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Config3 {
    @Bean
    public Date firstAccessDate() {
        return new Date();
    }
}
