package ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas
 * @date 2020/1/10 19:55
 * ++操作不是源自操作，光一个volatile是没有用的
 */
public class SynchronizedTest implements Runnable{

    private volatile AtomicInteger count = new AtomicInteger(0);
    // private volatile int count = 0;

    @Override
    public /*synchronized*/ void run() {
        count.getAndIncrement();
        // count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest r = new SynchronizedTest();
        for (int i = 0; i < 100; i++) {
            new Thread(r, "Thread"+i).start();
        }

    }
}
