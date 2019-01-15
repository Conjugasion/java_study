package ThreadDemo.lockDemo;

/**
 * @auther Lucas
 * @date 2019/1/14 14:37
 */
public class test {
    public static void main(String[] args) {
        ticket ticket = new ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.start();
        t2.start();
        t3.start();
    }
}
