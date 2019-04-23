package Atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author Lucas
 * @date 2019/4/19 21:53
 */
public class AtomicIntegerFieldUpdaterDemo {
    public static class Grade{
        int id;
        volatile int score;
    }

    public static final AtomicIntegerFieldUpdater<Grade> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Grade.class, "score");
    public static final AtomicInteger answer = new AtomicInteger(0);
    public static CountDownLatch latch = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
        final Grade g = new Grade();
        Thread[] t = new Thread[10000];
        for (int i = 0; i < 10000; i++) {
            t[i] = new Thread(){
                @Override
                public void run() {
                   if (Math.random() > 0.4){
                       scoreUpdater.incrementAndGet(g);
                       answer.incrementAndGet();
                   }
                }
            };
            t[i].start();
        }

        for (int i = 0; i < 10000; i++) {
            t[i].join();
        }
        System.out.println("Grade's score is " + g.score);
        System.out.println("answer is " + answer);
    }

}
