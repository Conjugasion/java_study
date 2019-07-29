package VolatileDemo;

/**
 * @author Lucas
 * @date 2019/5/17 22:24
 */
public class OutOfOrderTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            OutOfOrder obj = new OutOfOrder();
            Thread t1 = new Thread(() -> {
                new Thread(() -> obj.write()).start();

                new Thread(() -> obj.read()).start();
            });
            t1.start();
            t1.join();
        }
    }
}
