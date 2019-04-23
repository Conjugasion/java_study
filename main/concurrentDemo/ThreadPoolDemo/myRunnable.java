package concurrentDemo.ThreadPoolDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Lucas
 * @date 2019/3/26 16:51
 */
public class myRunnable implements Runnable {
    public static AtomicInteger i = new AtomicInteger(0);
    @Override
    public void run() {
        synchronized (i){
            System.out.println(Thread.currentThread().getName());
            if (i.get()==0){
                try {
                    throw new Exception("出错啦...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            i.addAndGet(1);
        }

    }
}
