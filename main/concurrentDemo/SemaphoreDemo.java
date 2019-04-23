package concurrentDemo;

import java.util.concurrent.Semaphore;

/**
 * @author Lucas
 * @date 2019/4/21 20:13
 */
public class SemaphoreDemo implements Runnable {
    public static Semaphore semaphore = new Semaphore(5);
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " done !");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new SemaphoreDemo()).start();
        }
    }
}
