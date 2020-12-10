package ConcurrentDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lucas
 * @date 2019/4/21 15:44
 */
public class DeadLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int i;

    public DeadLock(int i){
        this.i = i;
    }

    @Override
    public void run() {
        if(i == 1){
            lock1.lock();
            System.out.println("deadLock1抢到了lock1");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            System.out.println("deadLock1抢到了lock2");
        }else {
            lock2.lock();
            System.out.println("deadLock2抢到了lock2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock1.lock();
            System.out.println("deadLock2抢到了lock1");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DeadLock deadLock1 = new DeadLock(1);
        DeadLock deadLock2 = new DeadLock(2);
        Thread t1 = new Thread(deadLock1);
        Thread t2 = new Thread(deadLock2);
        t1.start();
        t2.start();
    }
}
