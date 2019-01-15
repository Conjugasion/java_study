package ThreadDemo.waitAndNotify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Lucas
 * @date 2019/1/14 16:35
 */
public class Resource {
    public static String name;
    public static String sex;
    public static Lock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    // public static Resource r = new Resource();
}
