package ThreadDemo;

/**
 * @author Lucas
 * @date 2020/1/10 21:09
 */
public class SynchronizedString {

    private String key = "key";

    void method1(){
        synchronized (key){
            System.out.println("method1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void method2(){
        synchronized (key){
            System.out.println("method2");
        }
    }

    public static void main(String[] args) {
        SynchronizedString s = new SynchronizedString();
        new Thread(){
            public void run(){
                s.method1();
            }
        }.start();

        new Thread(){
            public void run(){
                s.method2();
            }
        }.start();
    }
}
