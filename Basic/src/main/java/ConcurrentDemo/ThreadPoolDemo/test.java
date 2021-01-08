package ConcurrentDemo.ThreadPoolDemo;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Lucas
 * @date 2019/3/26 16:43
 */
public class test {

    public static void main(String[] args) {
        CustomThreadPoolTest exec = new CustomThreadPoolTest();
        exec.init();
        ThreadPoolExecutor pool = exec.getCustomThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.execute(new myRunnable());
        }
        pool.shutdown();
    }
}
