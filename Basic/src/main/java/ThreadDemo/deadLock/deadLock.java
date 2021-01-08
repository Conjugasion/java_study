package ThreadDemo.deadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Lucas
 * @date 2019/1/14 16:16
 */
public class deadLock implements Runnable{

    static final Lock a = new ReentrantLock();
    static final Lock b = new ReentrantLock();
    private int i = 0;
    @Override
    public void run() {
        while (true){
            if (i%2==0){
                synchronized (a){
                    System.out.println(Thread.currentThread().getName() + "...if...a");
                    synchronized (b){
                        System.out.println(Thread.currentThread().getName() + "...if...b");
                    }
                }
            }else {
                synchronized (b){
                    System.out.println(Thread.currentThread().getName() + "...else...b");
                    synchronized (a){
                        System.out.println(Thread.currentThread().getName() + "...else...a");
                    }
                }
            }
            i++;
        }
    }
}
