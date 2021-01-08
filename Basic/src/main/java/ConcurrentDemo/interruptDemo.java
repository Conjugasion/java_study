package ConcurrentDemo;

/**
 * @author Lucas
 * @date 2019/4/17 10:24
 */
public class interruptDemo {
    public static void main(String[] args ) throws InterruptedException {
//        MyThread1 thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("第一次调用thread.isInterrupted()："+thread1.isInterrupted());
//        System.out.println("第二次调用thread.isInterrupted()："+thread1.isInterrupted());
//        System.out.println("thread是否存活："+ thread1.isAlive());

//        MyThread2 thread2 = new MyThread2();
//        thread2.start();
//        thread2.interrupt();
//        //sleep等待一秒，等myThread运行完
//        Thread.sleep(1000);
//        System.out.println("mian线程是否被中断："+ Thread.interrupted());
//        System.out.println("myThread线程是否存活："+ thread2.isAlive());

        MyThread3 thread3 = new MyThread3();
        thread3.start();
    }

    public static class MyThread1 extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("i="+(i+1));
            }
        }
    }

    public static class MyThread2 extends Thread {
        @Override
        public  void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("i="+(i+1));
                if(this.isInterrupted()){
                    System.out.println("通过this.isInterrupted()检测到中断");
                    System.out.println("第一个interrupted()"+this.interrupted());
                    System.out.println("第二个interrupted()"+this.interrupted());
                    break;
                }
            }
            System.out.println("因为检测到中断，所以跳出循环，线程到这里结束，因为后面没有内容了");
        }
    }

    public static class MyThread3 extends Thread{

        @Override
        public void run(){
            while(true){
                Thread.yield();
                System.out.println("Thread.yield()");
            }
        }
    }

}
