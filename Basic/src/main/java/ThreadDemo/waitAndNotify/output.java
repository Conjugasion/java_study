package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 16:53
 */
public class output implements Runnable{
    @Override
    public void run() {
        while (true){
            synchronized(Resource.class){
                System.out.println("name: " + Resource.name + "..." + "sex: " + Resource.sex);
            }
        }
    }
}
