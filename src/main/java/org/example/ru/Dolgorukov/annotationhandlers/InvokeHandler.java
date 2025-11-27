package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.Invoke;

import java.lang.reflect.Method;

public class InvokeHandler {
    public static <T> void invokeVoid(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        Method[] methods = targetClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                method.invoke(object);
            }
        }
    }
}
