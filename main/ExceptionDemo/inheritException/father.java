package ExceptionDemo.inheritException;

import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/6 16:00
 */
public class father {
    public  void function1() throws IOException {
        System.out.println("father RuntimeException");
    }
    public  void fundtion2() {
        System.out.println("father no Exception");
    };
}
