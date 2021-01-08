package ThreadDemo.synchronizedDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther Lucas
 * @date 2019/1/14 10:45
 */
public class ticket implements Runnable {
    private AtomicInteger num1 = new AtomicInteger(100);
    static int num2 = 100;
    @Override
    public void run() {
        pay1();
    }

    public void pay1(){
        synchronized (ticket.class){
            while (num2 > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售第" + num2--);
            }
        }
    }

    public static synchronized void pay2(){
            while (num2 > 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "出售第" + num2--);
            }
    }
}
