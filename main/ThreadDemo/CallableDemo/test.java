package ThreadDemo.CallableDemo;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @auther Lucas
 * @date 2019/1/14 9:54
 */
public class test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(8);
//        Future<String> f1 = pool.submit(new CallableDemo());
//        String s1 = f1.get();
//        System.out.println(s1);
//
        FutureTask<Integer> f2 = new FutureTask<>(new CallableDemo(10));
        pool.submit(f2);
        int s2 = f2.get();
        System.out.println(s2);

        Future f3 = pool.submit(new CallableDemo(100));
        System.out.println(f3.get());
        Future f4 = pool.submit(new CallableDemo(200));
        System.out.println(f4.get());
    }
}
