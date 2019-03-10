package a1;

/**
 * @auther Lucas
 * @date 2019/3/7 23:43
 */
public class zi extends fu{
    static int b = 10;

    public zi(){

        System.out.println("我是子类");
    }

    static {
        System.out.println("zi static");
    }

    public static void func1(){
        new zi().func2();
        new fu().func2();
        System.out.println("zi func1");
        fu.func1();

    }

    @Override
    public  void func2(){
        System.out.println("zi func2");
         final class Inner{
             final int i = 10;
             private int a = 10;
             protected int c = 10;
//             static int b = 10;

        }
    }

    public static void main(String[] args) {
        func1();
    }

    private final static class Inner{
        final int i = 10;

    }
}
