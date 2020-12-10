package Atomic;

import org.junit.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Lucas
 * @date 2019/4/19 14:55
 * 自定义原子类
 */
public class AtomicReferenceDemo {
    public static final AtomicReference<String> atomicStr = new AtomicReference<>("abc");
    final CountDownLatch latch = new CountDownLatch(10);

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            new Thread(String.valueOf(i)) {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (atomicStr.compareAndSet("abc", "def")) {
                        System.out.println("Thread name is " + Thread.currentThread().getName() + " change value");
                    } else {
                        System.out.println("Thread name is " + Thread.currentThread().getName() + " failed");
                    }
                    latch.countDown();
                }
            }.start();

        }

        try {
            latch.await();
            System.out.println("所有线程均执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
