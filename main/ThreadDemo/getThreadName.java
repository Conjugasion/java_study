package ThreadDemo;

/**
 * @auther Lucas
 * @date 2019/1/13 22:31
 */
public class getThreadName {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread n1 = new NameThread("1号线程");
        n1.start();
    }

    public static class NameThread extends Thread{
        public NameThread(String name) {
            super(name);
        }

        public NameThread() {
        }

        @Override
        public void run() {
            System.out.println(super.getName());
        }
    }
}
