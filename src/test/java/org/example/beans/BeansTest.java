package org.example.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

class BeansTest {

    @Test
    @DisplayName("8.1.1")
    void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);
        String message = context.getBean("hello", String.class);
        System.out.println(message);
    }

    @Test
    @DisplayName("8.1.2")
    void test2() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        int firstRandom = context.getBean("randomInt", int.class);
        int secondRandom = context.getBean("randomInt", int.class);

        System.out.println("First number: " + firstRandom);
        System.out.println("Second number: " + secondRandom);
    }

    @Test
    @DisplayName("8.1.3")
    void test3() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        Date firstAccessDate = context.getBean(Date.class);
        System.out.println("Bean access time: " + firstAccessDate);
    }

    @Test
    @DisplayName("8.1.4")
    void test4() {
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
    @DisplayName("8.1.5")
    void test5() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config5.class);
        int min = context.getBean("min", Integer.class);
        int max = context.getBean("max", Integer.class);
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    @Test
    @DisplayName("8.2.1")
    void test6() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class, Config5.class);

        int min = context.getBean("min", Integer.class);
        int max = context.getBean("max", Integer.class);

        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            int randomNumber = context.getBean("randomInt", Integer.class);
            Assertions.assertTrue(randomNumber >= min && randomNumber <= max);
            Assertions.assertTrue(numberSet.add(randomNumber), "Generated number should not repeat");
        }
    }

    @Test
    @DisplayName("8.2.2, 8.2.3")
    void test7() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config5.class, Config2.class, ReviewConfig.class);
        Review review1 = context.getBean("review1", Review.class);
        Review review2 = context.getBean("review2", Review.class);
        Review review3 = context.getBean("review3", Review.class);
        System.out.println(context.getBean("bestReview"));

        Assertions.assertEquals("Very good", review1.getText());
        Assertions.assertEquals(4, review1.getRating());

        Assertions.assertEquals("Fine", review2.getText());
        Assertions.assertEquals(3, review2.getRating());

        int min = context.getBean("min", Integer.class);
        int max = context.getBean("max", Integer.class);

        Assertions.assertTrue(review3.getRating() >= min && review3.getRating() <= max);
    }

    @Test
    @DisplayName("8.2.7")
    void test8() {
        ApplicationContext context = new AnnotationConfigApplicationContext(TrafficLightConfig.class);
        TrafficLight tl = context.getBean(TrafficLight.class);

        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
        System.out.println(tl.next());
    }
}
