package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.Validate;

public class ValidateHandler {
    public static <T> void validateVoid(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        Validate defaultAnnotation = targetClass.getAnnotation(Validate.class);
        if (defaultAnnotation != null) {
            Class<?>[] defaultClass = defaultAnnotation.value();
            for (Class<?> clas : defaultClass){
                System.out.println(clas.getName());
            }
        } else {
            System.out.println("Аннотация @Validate не была применена");
        }
    }
}