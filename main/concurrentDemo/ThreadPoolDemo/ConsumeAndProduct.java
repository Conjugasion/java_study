package concurrentDemo.ThreadPoolDemo;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Lucas
 * @date 2019/4/22 19:47
 */
public class ConsumeAndProduct {
    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(10);
        Thread Product = new Thread(){
            @Override
            public void run() {
                int i = 0;
                while (true){
                    try {
                        queue.put(i);
                        System.out.println("生产者放入了 " + i + ", 现在queue里存在" + queue.size() + "个元素");
                        i++;
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread Consume = new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println("消费者取走了 " + queue.take());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Product.start();
        Consume.start();
    }
}
