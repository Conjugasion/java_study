package innerClass;

/**
 * @auther Lucas
 * @date 2018/12/29 10:02
 */
public class Outer3 {

    public void out(){
         class Inner{
            public void show(){
                System.out.println("局部内部类方法show");
            }
        }
        new Inner().show();
    }
}
