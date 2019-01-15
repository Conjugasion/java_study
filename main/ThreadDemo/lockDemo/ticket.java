package ThreadDemo.lockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Lucas
 * @date 2019/1/14 14:37
 */
public class ticket implements Runnable {
    int num = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        pay1();
    }

    private void pay1() {
        lock.lock();
        while (num > 0){
            try {
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + "出售第" + num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }
}
