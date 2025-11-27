package org.example.ru.Dolgorukov.annotationhandlers;

import org.example.ru.Dolgorukov.annotation.ToString;

import java.lang.reflect.Field;

public class ToStringHandler {
    public static <T> String toStringString(T object) throws Exception {
        Class<?> targetClass = object.getClass();
        String string = "";
        ToString.Mode defaultMode = null;
        ToString classAnnotation = targetClass.getAnnotation(ToString.class);
        if (classAnnotation != null) {
            defaultMode = classAnnotation.value();
            if (defaultMode == ToString.Mode.YES) {
                string += targetClass.getName() + " ";
            }
        }
        for (Field field : targetClass.getDeclaredFields()) {
            ToString fieldAnnotation = field.getAnnotation(ToString.class);
            if (fieldAnnotation != null) {
                if (fieldAnnotation.value() == ToString.Mode.YES) {
                    string += field.getName() + " ";
                }
            } else {
                if (defaultMode == ToString.Mode.YES) {
                    string += field.getName() + " ";
                }
            }
        }
        if (string == ""){
            string += "Аннотация @ToString не была применена";
        }
        return string;
    }
}