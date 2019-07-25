package ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas
 * @date 2019/7/25 14:39
 * 一个线程打印偶数，一个线程打印奇数
 *
 */
public class TakeTurnsPrintNum2 {
    static volatile boolean flag = true;
    static volatile int num = 1;
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (num<=10000){
                    if (flag&&num%2!=0){
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        flag = false;
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (num<=10000){
                    if (!flag&&num%2==0){
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        flag = true;
                    }
                }
            }
        }.start();
    }
}
