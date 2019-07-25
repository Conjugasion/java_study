package ThreadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Lucas
 * @date 2019/7/25 14:39
 * 一个线程打印偶数，一个线程打印奇数
 *
 */
public class TakeTurnsPrintNum3 {
    static int num = 1;
    static final Object obj = new Object();
    public static void main(String[] args) {
        //method2();
        //method1();
        method3();
    }

    // Reentrance
    static void method3(){
        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        new Thread(){
            @Override
            public void run() {
                lock.lock();
                while (num<=100){
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    c1.signal();
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c1.signal();
                lock.unlock();    // 必须显式释放锁
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                lock.lock();
                while (num<=100){
                    System.out.println(Thread.currentThread().getName() + ": " + num++);
                    c1.signal();
                    try {
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c1.signal();
                lock.unlock();
            }
        }.start();
    }



    // 自己的synchronized方法
    static void method1(){
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    while (num<=100){
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notify();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    while (num<=100){
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notify();
                }
            }
        }.start();
    }

    // 别人的方法
    static void method2(){
        final TakeTurnsPrintNum3 demo2 = new TakeTurnsPrintNum3();
        Thread t1 = new Thread(() -> demo2.print1());
        Thread t2 = new Thread(demo2::print2);

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

    public synchronized void print2() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {
                // NO
            }
        }
    }

    public synchronized void print1() {
        for (int i = 0; i <= 100; i += 2) {
            System.out.println(i);
            this.notify();
            try {
                this.wait();
                Thread.sleep(100);// 防止打印速度过快导致混乱
            } catch (InterruptedException e) {
                // NO
            }
        }
    }
}
