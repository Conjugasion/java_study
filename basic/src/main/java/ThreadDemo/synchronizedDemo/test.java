package ThreadDemo.synchronizedDemo;

/**
 * @auther Lucas
 * @date 2019/1/14 10:46
 */
public class test {
    public static void main(String[] args) {
        ticket ticket1 = new ticket();
        ticket ticket2 = new ticket();
        ticket ticket3 = new ticket();
        Thread t1 = new Thread(ticket1);
        Thread t2 = new Thread(ticket2);
        Thread t3 = new Thread(ticket3);
        t1.start();
        t2.start();
        t3.start();
    }
}
