package StaticInvoke;

/**
 * @auther Lucas
 * @date 2019/2/28 21:17
 */
public class Demo { class Super{  int flag=1;
    Super(){
        test();
    }  void test(){
        System.out.println("Super.test() flag="+flag);
    }
} class Sub extends Super{
    Sub(int i){  flag=i;
        System.out.println("Sub.Sub()flag="+flag);
    }  void test(){
        System.out.println("Sub.test()flag="+flag);
    }
}  public static void main(String[] args) {
    Demo.Super sup = new Demo().new Sub(5);
    Demo.Sub sub = new Demo().new Sub(5);
}
}
