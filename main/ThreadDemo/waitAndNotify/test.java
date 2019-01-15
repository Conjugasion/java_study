package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 18:28
 */
public class test {
    public static void main(String[] args) {
        input in = new input();
        output out = new output();

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        t1.start();
        t2.start();
    }
}
