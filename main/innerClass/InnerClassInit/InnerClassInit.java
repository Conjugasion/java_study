package innerClass.InnerClassInit;

/**
 * @author Lucas
 * @date 2019/5/20 19:07
 */
public class InnerClassInit {
    public static int a;
    public int b;
    static {
        System.out.println("static InnerClassInit");
    }

    static class InnerClass{
        static {
            System.out.println("static InnerClass init");
        }
        public static Instance instance = new Instance();
    }
    public static Instance getInstance(){
        return InnerClass.instance;
    }
}
