package ConcurrentDemo;

import java.util.concurrent.*;

/**
 * @author Lucas
 * @date 2019/4/22 14:10
 */
public class ExtThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("执行前");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行后");
            }

            @Override
            protected void terminated() {
                System.out.println("线程池终止啦");
            }
        };

        for (int i = 0; i < 10; i++) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " 启动 ！");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    latch.countDown();
                }
            });
        }
        latch.await();
        pool.shutdown();

    }
}
