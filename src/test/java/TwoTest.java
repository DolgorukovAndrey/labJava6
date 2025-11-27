import org.example.ru.Dolgorukov.annotation.Two;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class TwoTest {
    public <T> void valuesAnnotation(T object){
        Class<?> targetClass = object.getClass();
        Two defaultAnnotation = targetClass.getAnnotation(Two.class);
        if (defaultAnnotation.first() == "" || defaultAnnotation.second() < 0) {
            throw new IllegalArgumentException("Неверное значение параметров аннатации");
        }
    }

    @Two(first = "", second = -1)
    public static class InvalidClass {
    }

    @Test
    public void twoTest(){
        InvalidClass clas = new InvalidClass();
        assertThrows(IllegalArgumentException.class, () -> valuesAnnotation(clas));
    }
}

