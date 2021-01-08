package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 18:28
 */
public class test2 {
    public static void main(String[] args) {
        input2 in = new input2();
        output2 out = new output2();

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t2.start();
        t1.start();

    }
}
