package concurrentDemo;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas
 * @date 2019/4/22 15:33
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        AtomicInteger n = new AtomicInteger(0);
        for (int i = 0; i < 10; i++) {
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return n.incrementAndGet();
                }
            };
            Future<Integer> task = pool.submit(callable);
            System.out.println(task.get());
        }
        pool.shutdown();

    }
}
