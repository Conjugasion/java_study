package ThreadPoolDemo;

import java.io.Serializable;
import java.util.Deque;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther Lucas
 * @date 2019/3/7 15:09
 * 线程池初始化方法
 * corePoolSize 核心线程池大小----10
 * maximumPoolSize 最大线程池大小----30
 * keepAliveTime 线程池中超过corePoolSize数目的空闲线程最大存活时间----30+单位TimeUnit
 * TimeUnit keepAliveTime时间单位----TimeUnit.MINUTES
 * workQueue 阻塞队列----new ArrayBlockingQueue<Runnable>(10)====10容量的阻塞队列
 * threadFactory 新建线程工厂----new CustomThreadFactory()====定制的线程工厂
 * rejectedExecutionHandler 当提交任务数超过maxmumPoolSize+workQueue之和时,
 * 							即当提交第41个任务时(前面线程都没有执行完,此测试方法中用sleep(100)),
 * 						          任务会交给RejectedExecutionHandler来处理
 */
public class CustomThreadPool {
    private ThreadPoolExecutor pool;

    public void init(){
        pool = new ThreadPoolExecutor(5, 10, 30L,
                TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10), new CustomThreadFactory(),
                new CustomRejectedExecutionHandler());
    }

    public ThreadPoolExecutor getCustomThreadPool(){
        return  this.pool;
    }

    private class CustomRejectedExecutionHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            // 核心改造点，队列满了，那就轮询，发现空了，就插入一个
            try {
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private class CustomThreadFactory implements ThreadFactory {
        private AtomicInteger count = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String name =CustomThreadPool.class.getSimpleName() + count.addAndGet(1);
            System.out.println(name);
            t.setName(name);
            return t;
        }
    }
    public void destory(){
        if(pool != null){
            pool.shutdown();
        }
    }

    public static void main(String[] args) {
        CustomThreadPool exec = new CustomThreadPool();
        exec.init();
        ThreadPoolExecutor pool = exec.getCustomThreadPool();
        for (int i = 1; i <= 100; i++) {
            System.out.println("提交第" + i + "个任务!");
            pool.execute(() -> {
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(">>>task is running=====");
            });
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
