package ThreadDemo;

/**
 * @author Lucas
 * @date 2020/1/10 19:22
 * 线程的六种状态
 */
public class ThreadStatus {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread("test");
        System.out.println(t.getState());
        t.start();
        t.join();
        System.out.println(t.getState());
    }
}
