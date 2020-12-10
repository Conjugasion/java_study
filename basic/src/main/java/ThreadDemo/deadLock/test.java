package ThreadDemo.deadLock;

/**
 * @auther Lucas
 * @date 2019/1/14 16:20
 */
public class test {
    public static void main(String[] args) {
        Thread t1 = new Thread(new deadLock());
        Thread t2 = new Thread(new deadLock());

        t1.start();
        t2.start();
    }
}
