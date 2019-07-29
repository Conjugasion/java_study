package VolatileDemo;

/**
 * @author Lucas
 * @date 2019/5/17 9:10
 */
public class volatileFeatureTest {
    public static void main(String[] args) {
        volatileFeature v = new volatileFeature();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                v.increase();
                System.out.println(v.get());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                v.increase();
                System.out.println(v.get());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                v.increase();
                System.out.println(v.get());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                v.increase();
                System.out.println(v.get());
            }
        }).start();
    }
}
