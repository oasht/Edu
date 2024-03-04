package org.example.reflection;

import lombok.SneakyThrows;
import org.example.geometry.Line;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

public class ReflectionUtils {
    public static List<Field> getFields(Class clz) {
        List<Field> lst = new ArrayList<>();
        while (clz != null) {
            lst.addAll(Arrays.asList(clz.getDeclaredFields()));
            clz = clz.getSuperclass();
        }
        return lst;
    }

    @SneakyThrows
    public static void lineConnector(Line line1, Line line2) {
        Field lineStart = Line.class.getDeclaredField("start");
        lineStart.setAccessible(true);
        lineStart.set(line2, line1.getSecond());

    }

    @SneakyThrows
    public static Map<String, Object> collect(List<Class> clz) {
        Map<String, Object> map = new HashMap<>();
        for (Class clazz : clz) {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                if (m.getParameterCount() != 0) continue;
                if (m.getReturnType() == void.class) continue;
                if (!m.isAnnotationPresent(Invoke.class)) continue;
                if (Modifier.isStatic(m.getModifiers())) {
                    map.put(clazz.getSimpleName() + "." + m.getName(), m.invoke(null));
                } else {
                    Object o = clazz.getConstructor().newInstance();
                    map.put(clazz.getSimpleName() + "." + m.getName(), m.invoke(o));
                }
            }
        }
        return map;
    }

    static class Def {
        static Map<Class, Object> defaults = Map.of(
                String.class, "defaultString",
                int.class, 42
        );
    }

    @SneakyThrows
    public static void reset(List<Object> lst) {
        for (Object obj : lst) {
            Default annotation = obj.getClass().getAnnotation(Default.class);
            List<Field> fields = getFields(obj.getClass());
            if (annotation == null) {
                fields = fields.stream()
                        .filter(f -> f.isAnnotationPresent(Default.class))
                        .toList();
            }
            for (Field f : fields) {
                Class clazz = f.getType();
                Default an = f.getAnnotation(Default.class);
                if (an != null && an.value() != void.class) {
                    clazz = an.value();
                }
                Object def = Def.defaults.get(clazz);
                if (def != null) {
                    f.set(obj, def);
                } else {
                    if (Object.class.isAssignableFrom(f.getType())) {
                        f.set(obj, null);
                    } else {
                        if (f.getType() == int.class) f.set(obj, 0);
                        if (f.getType() == double.class) f.set(obj, 0.0d);
                        if (f.getType() == float.class) f.set(obj, 0.0f);
                        if (f.getType() == char.class) f.set(obj, (char) 0);
                        if (f.getType() == boolean.class) f.set(obj, false);
                        if (f.getType() == byte.class) f.set(obj, (byte) 0);
                        if (f.getType() == short.class) f.set(obj, (short) 0);
                    }
                }
            }
        }
    }



}
