package concurrentDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lucas
 * @date 2019/4/21 18:32
 */
public class ConditionDemo {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition c1 = lock.newCondition();
    public static Condition c2 = lock.newCondition();

    public static class A implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try{
                for (int i = 0; i < 10; i++) {
                    System.out.println("A 抢到了lock锁");
                    c2.signal();
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                c2.signal();
                System.out.println("A signal c2并且unlock");
                lock.unlock();
            }
        }
    }

    public static class B implements Runnable{
        @Override
        public void run() {
            lock.lock();
            try{
                for (int i = 0; i < 10; i++) {
                    System.out.println("B 抢到了lock锁");
                    c1.signal();
                    try {
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("B的c2被signal");
            }finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        new Thread(new A()).start();
        new Thread(new B()).start();
    }


}
