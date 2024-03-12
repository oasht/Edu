package org.example.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Comparator;
import java.util.Optional;

@Configuration
public class ReviewConfig {

    @Bean
    public Review review1() {
        return new Review("Very good", 4);
    }

    @Bean
    public Review review2() {
        return new Review("Fine", 3);
    }

    @Bean
    public Review review3(@Qualifier("randomInt") Integer randomInt) {
        String text = "Hard to say";
        return new Review(text, randomInt);
    }

    @Bean
    @Scope("prototype")
    Optional<Review> bestReview(ApplicationContext ctx){
        return ctx.getBeansOfType(Review.class).values().stream()
            .peek(System.out::println)
            .max(Comparator.comparingInt(review -> review.getRating()));
    }
}
