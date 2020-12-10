package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 16:36
 */
public class input2 implements Runnable{
    int i = 0;
    @Override
    public void run() {
        while (true){
            try{
                Resource.lock.lock();
                if (i%2==0){
                    Resource.name = "lucas";
                    Resource.sex = "male";
                }else {
                    Resource.name = "selina";
                    Resource.sex = "female";
                }
                i++;
                Resource.condition.signal();
                try {
                    Resource.condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                Resource.lock.unlock();
            }



        }
    }
}
