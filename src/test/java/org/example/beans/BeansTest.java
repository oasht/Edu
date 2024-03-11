package org.example.beans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.function.Predicate;

class BeansTest {

    @Test
    @DisplayName("8.1")
    void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        String message = context.getBean("hello", String.class);
        System.out.println(message);
    }
    @Test
    @DisplayName("8.2")
    void test2(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        int firstRandom = context.getBean("randomInt", int.class);
        int secondRandom = context.getBean("randomInt", int.class);

        System.out.println("First number: " + firstRandom);
        System.out.println("Second number: " + secondRandom);
    }

    @Test
    @DisplayName("8.3")
    void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        Date firstAccessDate = context.getBean(Date.class);
        System.out.println("Bean access time: " + firstAccessDate);
    }

    @Test
    @DisplayName("8.4")
    void test4(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config4.class);
        Predicate<Integer> predicate = context.getBean("checkNumber", Predicate.class);
        int number = 3;
        if (predicate.test(number)) {
            System.out.println(number + " is within a range of 2 to 5");
        } else {
            System.out.println(number + " is out of a range of 2 to 5");
        }

    }

    @Test
    @DisplayName("8.5")
    void test5(){

        ApplicationContext context = new AnnotationConfigApplicationContext(Config5.class);
        int min = context.getBean("min", Integer.class);
        int max = context.getBean("max", Integer.class);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}