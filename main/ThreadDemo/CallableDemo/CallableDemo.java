package ThreadDemo.CallableDemo;

import java.util.concurrent.Callable;

/**
 * @auther Lucas
 * @date 2019/1/14 9:51
 */
public class CallableDemo implements Callable {

    private int a;
    public CallableDemo(int a) {
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum = sum + i;
        }
        return sum;
    }
}
