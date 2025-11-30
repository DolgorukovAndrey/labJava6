package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.Cache;


public class CacheHandler {
    public static <T> void cacheVoid(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        Cache defaultAnnotation = targetClass.getAnnotation(Cache.class);
        if (defaultAnnotation != null) {
            String[] strings = defaultAnnotation.value();
            if (strings.length == 0){
                System.out.println("Аннотация @Cache была применена, но список значений пуст");
            } else {
                for (String string : strings){
                    System.out.println(string);
                }
            }
        } else {
            System.out.println("Аннотация @Cache не была применена");
        }
    }
}