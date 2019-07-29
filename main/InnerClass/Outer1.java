package InnerClass;

/**
 * @auther Lucas
 * @date 2018/12/29 9:41
 */
public class Outer1 {
    private int a = 1;
     class Inner{
         int b = 2;
        public void show(){
            System.out.println("内部类方法show " + a);
        }
    }
    public void show(){
        System.out.println("外部类方法show " + new Outer1().new Inner().b);
    }
}
