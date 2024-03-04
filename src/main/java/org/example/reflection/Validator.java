package org.example.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Validator {
    public static void validate(Object objectForTest) throws ValidationException {
        try {
            Class[] testClasses = objectForTest.getClass()
                    .getDeclaredAnnotation(Validate.class).value();
            for (Class testClass : testClasses) {
                Constructor cstr = testClass.getDeclaredConstructor();
                cstr.setAccessible(true);
                Object testerObject = cstr.newInstance();
                Method[] tests = testClass.getDeclaredMethods();
                for (Method test : tests) {
                    System.out.println("Testing with: "+test.getName());
                    test.setAccessible(true);
                    test.invoke(testerObject, objectForTest);
                }
            }

        }
        catch(InvocationTargetException error){
            Throwable throwable = error.getCause();
            if(throwable.getClass()== ValidationException.class){
                throw (ValidationException)throwable;
            }
            throw new RuntimeException(throwable);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}



