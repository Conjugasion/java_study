package concurrentDemo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Lucas
 * @date 2019/4/21 23:03
 */
public class LockSupportDemo {
    public static void main(String[] args) {
//        func1();
//        func2();
//        func3();
//        func4();
        func5();

//        Thread mainThread = Thread.currentThread();
//        System.out.println("unpark...1");
//        LockSupport.unpark(mainThread);
//        System.out.println("unpark...2");
//        LockSupport.unpark(mainThread);
//
//        System.out.println("park 1");
//        LockSupport.park();
//
//        // 可以通过别的线程给mainThread发许可
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LockSupport.unpark(mainThread);
//            }
//        }).start();
//
//        LockSupport.park();
//        System.out.println("park 2");



    }


    // object.wait/notify 必须在同步代码块内部synchronized
    public static void func1(){
        Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj){
            obj.notify();
        }
    }

    // LockSupport不需要在同步代码块内部
    public static void func2(){
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                LockSupport.park();
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        //睡眠一秒钟，保证线程A已经计算完成，阻塞在wait方法
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(A);
        LockSupport.unpark(A);
    }

    // notify和wait顺序不能颠倒
    public static void func3(){
        Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                try {
                    synchronized (obj){
                        obj.wait();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(sum);
            }
        });
        A.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (obj){
            obj.notify();
        }
    }

    public static void func4(){
        Object obj = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        LockSupport.unpark(A);
    }

    // park可被中断
    public static void func5(){
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for(int i=0;i<10;i++){
                    sum+=i;
                }
                LockSupport.park();
                System.out.println(sum);
            }
        });
        A.start();
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                A.interrupt();
                System.out.println(A.isInterrupted());
            }
        });
        B.start();
    }
}
