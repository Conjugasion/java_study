package volatileDemo;

/**
 * @author Lucas
 * @date 2019/5/17 9:40
 */
public class volatileTest {
    public static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = false;
                System.out.println(Thread.currentThread().getName() + "修改 flag 为" + flag);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                }
                System.out.println(Thread.currentThread().getName() + "线程停止，死循环被打开");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag) {
                }
                System.out.println(Thread.currentThread().getName() + "线程停止，死循环被打开");
            }
        }).start();

    }
}
