package ThreadDemo;

/**
 * @auther Lucas
 * @date 2019/1/13 22:55
 */
public class RunnableDemo {
    public static void main(String[] args) {
        new Thread(new Runnable1()).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        System.out.println("show diff");
    }

    public static class Runnable1 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
