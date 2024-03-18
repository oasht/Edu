package org.example.postprocessors;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.example.reflection.Cache;
import org.example.reflection.Default;
import org.example.reflection.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Log4j2
public class NameFieldPostProcessor implements BeanPostProcessor {

    @Autowired
    ApplicationContext ctx;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass() == TestObject.class) setVasia(bean);
        setDefaults(bean);
        //reset(bean);
        bean = cache(bean);
        return bean;
    }

    private void setVasia(Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals("name") && field.getType() == String.class) {
                try {
                    field.setAccessible(true);
                    if (field.get(bean) == null) {
                        log.info("Field name is null, setting default value for {}", bean);
                        field.set(bean, "vasia");
                        log.info("Field name is set: {}", bean);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SneakyThrows
    private void setDefaults(Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();

        if (clazz.isAnnotationPresent(Default.class)) {
            String beanName = clazz.getAnnotation(Default.class).value();
            Object def = ctx.getBean(beanName);
            Method method = def.getClass().getMethod("getDefaults", Class.class);
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(bean) != null) {
                    continue;
                }
                field.set(bean, method.invoke(def, field.getType()));
            }
        } else {
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Default.class)) {
                    continue;
                }
                field.setAccessible(true);
                if (field.get(bean) != null) {
                    continue;
                }
                String beanName = field.getAnnotation(Default.class).value();
                field.set(bean, ctx.getBean(beanName));
            }
        }
    }

    @SneakyThrows
    private void reset(Object bean) {
        Class<?> clazz = bean.getClass();
        Field[] fields = clazz.getDeclaredFields();

        if (clazz.isAnnotationPresent(Default.class)) {
            String beanName = clazz.getAnnotation(Default.class).value();
            Object def = ctx.getBean(beanName);
            Method method = def.getClass().getMethod("getDefaults", Class.class);
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(bean, method.invoke(def, field.getType()));
            }
        } else {
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Default.class)) {
                    continue;
                }
                field.setAccessible(true);
                String beanName = field.getAnnotation(Default.class).value();
                field.set(bean, ctx.getBean(beanName));
            }
        }
    }

    @SneakyThrows
    private Object cache(Object bean){
        if(!Arrays.stream(bean.getClass().getDeclaredMethods()).anyMatch(m -> m.isAnnotationPresent(Cache.class))) return bean;
        return ReflectionUtils.cache(bean);
    }

}
