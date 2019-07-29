package ConcurrentDemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Lucas
 * @date 2019/4/21 20:28
 */
public class ReadWriteLockDemo {
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public static void main(String[] args) {
//        func1();
        func2();
    }

    public static void func1(){
        readLock.lock();
        System.out.println("I'm reading");
//        readLock.unlock();              // 必须释放读锁后才能写操作
        writeLock.lock();
        System.out.println("I'm writing");
    }

    public static void func2(){
        writeLock.lock();
        System.out.println("I'm writing");
        readLock.lock();
        System.out.println("So, I can read");
    }
}
