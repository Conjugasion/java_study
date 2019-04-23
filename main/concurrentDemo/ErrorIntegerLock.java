package concurrentDemo;

/**
 * @author Lucas
 * @date 2019/4/23 10:16
 * i 是会变的，每次锁住的i都不是同一个
 */
public class ErrorIntegerLock {
    static Integer i = 0;
    public static class AddThread extends Thread{
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                synchronized (i){
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread a = new AddThread();
        AddThread b = new AddThread();
        a.start();
        b.start();
        a.join();
        b.join();
        System.out.println(i);
    }
}
