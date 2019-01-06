package ExceptionDemo.inheritException;

import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/6 16:00
 */
public class son extends father {
    @Override
    public void function1() throws IOException {
        System.out.println("son RuntimeException");
    }

    @Override
    public void fundtion2() {
        System.out.println("son only no Except");
    }
}
