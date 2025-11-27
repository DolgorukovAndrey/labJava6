package org.example;

import org.example.ru.Dolgorukov.additionalclasses.TestAnnotaion;

import static org.example.ru.Dolgorukov.annotationhandlers.CacheHandler.cacheVoid;
import static org.example.ru.Dolgorukov.annotationhandlers.DefaultHandler.defaultVoid;
import static org.example.ru.Dolgorukov.annotationhandlers.InvokeHandler.invokeVoid;
import static org.example.ru.Dolgorukov.annotationhandlers.ToStringHandler.toStringString;
import static org.example.ru.Dolgorukov.annotationhandlers.TwoHandler.twoVoid;
import static org.example.ru.Dolgorukov.annotationhandlers.ValidateHandler.validateVoid;

public class Main {
    public static void main(String[] args) throws Exception {
        TestAnnotaion obj = new TestAnnotaion();
        invokeVoid(obj);
        defaultVoid(obj);
        System.out.println(toStringString(obj));
        validateVoid(obj);
        twoVoid(obj);
        cacheVoid(obj);
    }
}