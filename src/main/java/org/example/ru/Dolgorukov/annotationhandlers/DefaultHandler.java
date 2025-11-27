package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.Default;

public class DefaultHandler {
    public static <T> void defaultVoid(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        Default defaultAnnotation = targetClass.getAnnotation(Default.class);
        if (defaultAnnotation != null) {
            Class<?> defaultClass = defaultAnnotation.value();
            System.out.println(defaultClass.getName());
        } else {
            System.out.println("Аннотация @Default не была применена");
        }
    }
}