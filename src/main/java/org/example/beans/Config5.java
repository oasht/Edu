package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config5 {
    @Bean
    public int max() {
        return 100;
    }

    @Bean
    public int min() {
        return 1;
    }
}
