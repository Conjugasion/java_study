package innerClass;

/**
 * @auther Lucas
 * @date 2019/2/25 21:30
 */
class OuterClass {
    public static void zxc(){
        System.out.println("zxc");
    }
//    public static void main(String[] args) {
//        String s = null;
//        System.out.println(s.length());
//    }
    private float f = 1.0f;
//    class InnerClass{
//        public static float func(){
//            return f;
//        }
//    }

    public class InnerClass{
        public float func(){return f;}

        public float func1(){
            float a = func();
            return a;
        }
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass().new InnerClass();
        System.out.println(inner.func());
        System.out.println(inner.func1());
    }

}
