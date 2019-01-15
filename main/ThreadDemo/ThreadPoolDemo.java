package ThreadDemo;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther Lucas
 * @date 2019/1/14 9:37
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 调用工厂类的静态方法
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

    }
}
