package StaticInvoke;

/**
 * @auther Lucas
 * @date 2019/1/8 23:30
 */
public class strange {
    static strange s1 = new strange();
    static strange s2 = new strange();

    static {
        System.out.print("静态块   ");
    }
    {
        System.out.print("构造块   ");
    }

    public strange(){
        System.out.print("构造方法   ");
    }

    public static void main(String[] args) {
        new strange();
        // 构造块 构造方法 构造块 构造方法 静态块 构造块 构造方法
    }
}
