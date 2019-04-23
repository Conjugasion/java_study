package innerClass;

/**
 * @author Lucas
 * @date 2019/4/22 16:21
 */
public class staticInnerClass {
    static class InnerClass{
        public static String InnerClassWord = "InnerClass's InnerClassWord";
        static {
            System.out.println("InnerClass is created !");
        }
    }

    public static String word = "staticInnerClass's word";
    static {
        System.out.println("staticInnerClass's static块");
    }

    public static void main(String[] args) {
        // System.out.println(word);
        System.out.println(InnerClass.InnerClassWord);
    }

}
