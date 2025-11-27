package org.example.ru.Dolgorukov.additionalclasses;

import org.example.ru.Dolgorukov.annotation.*;

@Cache({"string1","string3"})
@Two(first = "First",second = 2)
@Validate({String.class, Integer.class})
@ToString
@Default(String.class)
public class TestAnnotaion {
    @ToString(ToString.Mode.NO)
    private String string1;
    private String string2;
    private String string3;

    @Invoke
    public void method1(){
        System.out.println("метод 1");
    }
    public void method2(){
        System.out.println("метод 2");
    }
    public void method3(){
        System.out.println("метод 3");
    }
}
