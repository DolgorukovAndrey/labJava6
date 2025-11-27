package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.Two;

public class TwoHandler {
    public static <T> void twoVoid(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        Two defaultAnnotation = targetClass.getAnnotation(Two.class);
        if (defaultAnnotation != null) {
            String first = defaultAnnotation.first();
            int second = defaultAnnotation.second();
            System.out.println(first + " " + second);
        } else {
            System.out.println("Аннотация @Two не была применена");
        }
    }
}