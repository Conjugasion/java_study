package InnerClass;

/**
 * @author Lucas
 * @date 2019/6/20 17:24
 */
class WithInner {
    class Inner {
        int a;
        Inner(){
            System.out.println("this is a constructor in WithInner.Inner");
        };
        void run(){
            final int j = 0;
            int k;
        }
    }

    public static void main(String[] args) {
        Inner inner = new WithInner().new Inner();
        System.out.println(inner.a);
    }
}