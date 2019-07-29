package InnerClass;

/**
 * @auther Lucas
 * @date 2018/12/29 9:55
 */
public class Outer2 {
    static {
        System.out.println("outer2 static");
    }
    {
        System.out.println("outer2 no static");
    }
    public Outer2(){
        System.out.println("outer2 constructor");
    }
    int i = 1;
    class Inner{
        {
            System.out.println("inner no static");
        }
        public Inner(){
            System.out.println("inner constructor");
        }
        int i = 2;
        public void show(){
            int i = 3;
            System.out.println(i);
            System.out.println(this.i);
            System.out.println(Outer2.this.i);
        }
    }
}
