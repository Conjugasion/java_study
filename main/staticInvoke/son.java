package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:25
 */
public class son extends father {
    static int i = 2;
    static int m = 2;
    int j = 20;
    int k = 30;
    static final int o = 200;

    static {
        System.out.println("son static");
    }

    {
        System.out.println("son not static");
    }

    public son(){
        System.out.println("son 构造方法");
    }

    public void run(){
        System.out.println("son no static run");
    }

    public static void eat(){
        System.out.println("son static eat");
    }

    public void say(){
        System.out.println("son say");
    }

    public void swim(){
        System.out.println("son static swim");
    }
    public static void basket(){
        System.out.println("son static basket");
    }
}
