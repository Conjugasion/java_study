package finalDemo.finalMethod;

/**
 * @auther Lucas
 * @date 2018/12/28 15:15
 * 被final修饰的方法不能被重写，可以被重载
 */
public class father {
    public final void show(){
        System.out.println("父类的final方法");
    }


    public void show(int age){
        System.out.println("父类的final方法");
    }
}
