package org.example.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class Config4 {
    @Bean
    public Predicate<Integer> checkNumber() {
        return number -> number >= 2 && number <= 5;
    }
}
