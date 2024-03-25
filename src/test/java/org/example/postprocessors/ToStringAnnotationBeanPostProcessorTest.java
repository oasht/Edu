package org.example.postprocessors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToStringAnnotationBeanPostProcessorTest {
    @Test
    @DisplayName("8.3.3")
    void testDefinitions() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ToStringAnnotationBeanPostProcessorTest.Config.class,
                ToStringAnnotationBeanPostProcessor.class);
        String actual = context.getBean(TestObject4.class).toString();
        String expected = "name=Test, x=10";
        assertEquals(expected, actual);
    }

    @Configuration
    static class Config {
        @Bean
        public TestObject4 testObject4() {
            return new TestObject4();
        }
    }

}