package Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Lucas
 * @date 2019/4/19 16:53
 */
public class AtomicIntegerArrayDemo {
    public static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    public static CountDownLatch count = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        arr.getAndIncrement(j%arr.length());
                    }
                    count.countDown();
                }
            }.start();
        }
        count.await();
        System.out.println(arr);

        System.out.println(4 << 2);
    }
}
