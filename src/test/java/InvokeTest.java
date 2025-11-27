import org.example.ru.Dolgorukov.annotation.Invoke;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvokeTest {
    public static class Methods{
        private int count;

        public Methods(){
            count = 0;
        }

        @Invoke
        public int method1(int a,int b){
            return a + b;
        }

        @Invoke
        public String method2(String a,String b){
            return a + b;
        }

        @Invoke
        public Boolean method3(int a,int b){
            return a < b;
        }

        @Invoke
        public void metohd4(){
            count += 10;
        }

        public int getCount(){
            return count;
        }
    }

    private Methods methods;

    @BeforeEach
    public void setUp(){
        methods = new Methods();
    }

    @Test
    public void testInvoke() throws InvocationTargetException, IllegalAccessException {
        Method[] methodsList = methods.getClass().getDeclaredMethods();
        for (Method method : methodsList) {
            if (method.isAnnotationPresent(Invoke.class)) {
                method.setAccessible(true);
                assertDoesNotThrow(() -> {
                    if (method.getName().equals("method1")) {
                        assertEquals(8, method.invoke(methods, 5, 3));
                    }
                    if (method.getName().equals("method2")) {
                        assertEquals("11", method.invoke(methods, "1", "1"));
                    }
                    if (method.getName().equals("method3")) {
                        assertEquals(true, method.invoke(methods, 2, 5));
                    }
                    if (method.getName().equals("method4")) {
                        int countBefore = methods.getCount();
                        method.invoke(methods);
                        assertEquals(countBefore + 10, methods.getCount());
                    }
                }, "Выброшено исключение в " + method.getName());
            }
        }
    }
}
