package org.example.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Configuration
public class Config2 {
    private Set<Integer> numberSet;

/*     @Autowired
    public Config2(@Qualifier("min")Integer min,@Qualifier("max") Integer max) {
        this.min = min;
        this.max = max;
        this.numberSet = new HashSet<>();
    }
     */

    @Scope("prototype")
    @Bean
    public Integer randomInt(@Qualifier("min") int min, @Qualifier("max") int max) {
        if(numberSet == null) numberSet = new HashSet<>();

        Random random = new Random();
        int randomNumber;

        if (numberSet.size() >= max - min + 1) {
            numberSet.clear();
        }
        do {
            randomNumber = random.nextInt(max - min + 1) + min;
        } while (numberSet.contains(randomNumber));
        numberSet.add(randomNumber);
        return randomNumber;
    }
}
