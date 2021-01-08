package ThreadDemo.CallableAndFuture;

import java.util.concurrent.*;

/**
 * @auther Lucas
 * @date 2019/1/14 9:54
 * Callable和Future，通过它们可以在任务执行完毕之后得到任务执行结果。
 */
public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(8);
        // FutureTask使用方式一
        Future<Integer> f1 = pool.submit(new CallableDemo(10));
        //int s1 = f1.get();       // 该方法是个阻塞方法，在未得到结果之前，一直会等待
        //System.out.println(s1);

        // FutureTask使用方式二
        FutureTask<Integer> f2 = new FutureTask<>(new CallableDemo(10));
        pool.submit(f2);
        //int s2 = f2.get();       // 该方法是个阻塞方法，在未得到结果之前，一直会等待
        //System.out.println(s2);

        Future f3 = pool.submit(new CallableDemo(100));
        //System.out.println(f3.get());
        Future f4 = pool.submit(new CallableDemo(200));
        System.out.println(f1.get());                      // 可以先一口气提交所有任务，最后一次性获取结果
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        pool.shutdown();
    }
}
