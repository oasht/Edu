package org.example.postprocessors;

import lombok.SneakyThrows;
import org.example.reflection.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class ToStringAnnotationBeanPostProcessor implements BeanPostProcessor {
    Map<String, Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (Arrays.stream(bean.getClass().getDeclaredFields()).anyMatch(f -> f.isAnnotationPresent(ToString.class)))
            beans.put(beanName, bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beans.containsKey(beanName)) {
            beans.remove(beanName);
            return toString(bean);
        }
        return bean;
    }

    @SneakyThrows
    private Object toString(Object bean) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (!method.getName().equals("toString")) return proxy.invokeSuper(obj, args);
            if (method.getParameterCount() != 0) return proxy.invokeSuper(obj, args);
            return
                    Arrays.stream(bean.getClass().getDeclaredFields())
                            .peek(f -> f.setAccessible(true))
                            .filter(f -> f.isAnnotationPresent(ToString.class))
                            .map(f -> {
                                try {
                                    return f.getName() + "=" + f.get(bean);
                                } catch (IllegalAccessException e) {
                                    throw new RuntimeException(e);
                                }
                            })
                            .reduce((s1, s2) -> s1 + ", " + s2)
                            .orElse("");
        });
        return enhancer.create();
    }


}
