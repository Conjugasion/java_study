package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:25
 */
public class son extends father {
    static int i = 2;
    int j = 20;
    int k = 30;

    public void run(){
        System.out.println("son no static run");
    }

    public static void eat(){
        System.out.println("son static eat");
    }

    public void say(){
        System.out.println("son say");
    }
}
