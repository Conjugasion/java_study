package systemDemo;

import java.util.Date;

/**
 * @auther Lucas
 * @date 2019/1/3 21:12
 * 垃圾回收
 */
public class gcDemo {
    public static void main(String[] args) {
        new Date();
        new Date();
        new Date();
        new Date();
        new Date();
        new Date();
        new Date();
        System.gc();

    }
}
