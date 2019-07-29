package ConcurrentDemo;

/**
 * @author Lucas
 * @date 2019/4/17 16:34
 */
public class synchronizedDemo extends Thread{
    static int i = 0;

    @Override
    public void run() {
        synchronized (synchronizedDemo.class){
            for (int j = 0; j < 10000000 ; j++) {
                i ++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new synchronizedDemo();
        Thread t2 = new synchronizedDemo();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(synchronizedDemo.i);
    }
}
