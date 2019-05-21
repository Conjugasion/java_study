package innerClass.InnerClassInit;

/**
 * @author Lucas
 * @date 2019/5/20 19:09
 */
public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        System.out.println(InnerClassInit.InnerClass.instance);
//        InnerClassInit.a = 10;
        Class<?> aClass = Class.forName("innerClass.InnerClassInit.InnerClassInit");
        aClass.getMethod("getInstance",null);
    }
}
