package ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas
 * @date 2019/7/25 14:39
 * 线程一 1 2 3 线程二 4 5 6 线程一 7 8 9 ...
 *
 */
public class TakeTurnsPrintNum1 {
    static volatile boolean flag = true;
    static AtomicInteger i = new AtomicInteger(1);
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (i.get()<=100){
                    if (flag){
                        for (int j = 0; j < 3; j++) {
                            int curValue = i.getAndIncrement();
                            if (curValue<=100){
                                System.out.println(Thread.currentThread().getName() + ": " + curValue);
                            }
                        }
                        flag = false;
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (i.get()<=100){
                    if (!flag){
                        for (int j = 0; j < 3; j++) {
                            int curValue = i.getAndIncrement();
                            if (curValue<=100){
                                System.out.println(Thread.currentThread().getName() + ": " + curValue);
                            }
                        }
                        flag = true;
                    }
                }
            }
        }.start();
    }
}
