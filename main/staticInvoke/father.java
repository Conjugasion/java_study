package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:25
 */
public class father {
    static int i = 1;
    int j = 10;
    static int l = 40;
    static final int n = 100;

    static {
        System.out.println("father static");
    }

    {
        System.out.println("father not static");
    }

    public father(){
        System.out.println("father 构造方法");
    }

    public void run(){
        System.out.println("father no static run");
    }
    public static void eat(){
        System.out.println("father static eat");
    }
    public static void tennis(){
        System.out.println("father static tennis");
    }
}
