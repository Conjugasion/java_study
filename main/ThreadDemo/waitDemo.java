package ThreadDemo;

/**
 * @author Lucas
 * @date 2019-12-08 15:29
 */
public class waitDemo {
    public static void main(String[] args) throws InterruptedException {
        new Thread("子线程"){
            @Override
            public void run(){
                synchronized (waitDemo.class){
                    while (true){
                        System.out.println(Thread.currentThread().getName() + "运行中");
                        System.out.println("-------------");
                        waitDemo.class.notify();
                        try {
                            waitDemo.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        synchronized (waitDemo.class){
            while (true){
                System.out.println(Thread.currentThread().getName() + "运行中");
                System.out.println("-------------");
                waitDemo.class.notify();
                waitDemo.class.wait();

            }
        }
    }
}
