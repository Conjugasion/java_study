package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:25
 */
public class father {
    static int i = 1;
    int j = 10;

    public void run(){
        System.out.println("father no static run");
    }
    public static void eat(){
        System.out.println("father static eat");
    }
}
