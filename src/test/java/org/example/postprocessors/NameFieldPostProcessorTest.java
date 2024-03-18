package org.example.postprocessors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


class NameFieldPostProcessorTest {

    @Test
    @DisplayName("8.3.1")
    void testPostProcessor() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class, NameFieldPostProcessor.class);
        TestObject testObject = context.getBean(TestObject.class);
        assertEquals("vasia", testObject.getName());
    }

    @Test
    @DisplayName("8.3.2")
    void testPostProcessor2() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class, NameFieldPostProcessor.class);
        TestObject2 testObject2 = context.getBean(TestObject2.class);
        System.out.println(testObject2);
    }

    @Test
    @DisplayName("8.3.5")
    void testCache() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class,
                NameFieldPostProcessor.class, DefinitionPostProcessor.class);
        TestInterface o = (TestInterface) context.getBean("testObject3");
        o.test();
        o.test();
    }

    @Test
    @DisplayName("8.3.6")
    void testDefinitions() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class,
                NameFieldPostProcessor.class, DefinitionPostProcessor.class);
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
        System.out.println(context.getBean("random"));
    }

    @Configuration
    static class Config {
        @Bean
        public TestObject testObject() {
            return new TestObject();
        }

        @Bean
        public TestObject2 testObject2() {
            return new TestObject2();
        }

        @Bean
        public TestInterface testObject3() {
            return new TestObject3();
        }

        @Bean
        String defaultString() {
            return "default";
        }

        @Bean
        DefaultClass defaultClass() {
            return new DefaultClass();
        }
    }


    static class DefaultClass {
        Map<Class, Object> map = Map.of(
                String.class, "defString",
                Integer.class, 100
        );

        public Object getDefaults(Class clazz) {
            return map.get(clazz);
        }
    }

}
