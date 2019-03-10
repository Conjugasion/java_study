package a1;

/**
 * @auther Lucas
 * @date 2019/3/7 23:42
 */
public class fu {

    public fu(){
        System.out.println("我是父类");
    }

    static {
        System.out.println("fu static");
    }
    public static void func1(){
        System.out.println("fu func1");
    }
    public void func2(){
        System.out.println("fu func2");
    }
}
