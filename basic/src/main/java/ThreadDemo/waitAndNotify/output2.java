package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 16:53
 */
public class output2 implements Runnable{
    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(10);
                Resource.lock.lock();
                System.out.println("name: " + Resource.name + "..." + "sex: " + Resource.sex);
                Resource.condition.signal();
                try {
                    Resource.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Resource.lock.unlock();
            }

        }
    }
}
