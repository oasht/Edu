package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Random;

@Configuration
public class Config2 {
    @Scope("prototype")
    @Bean
    public Integer randomInt() {
        Random random = new Random();
        return random.nextInt(100);
    }
}
