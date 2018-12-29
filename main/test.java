import org.junit.Test;

/**
 * @auther Lucas
 * @date 2018/12/28 9:16
 */
public class test {
    public class Father{
        public void method(){
            System.out.println("father");
        }
    }
    public class Son extends Father{
        public void method(){
            System.out.println("son");
        }
        public void methodB(){
            System.out.println("sonson");
        }
    }

    @Test
    public void test1(){
        Father f = new Son();
        System.out.println(f.getClass());
        f.method();
        // 报错
        // f.methodB();
    }

    @Test
    public void test2(){
        int x = 5;
        int y = 10;
        System.out.println(x+y+""+(x+y)+y);  //151510
    }
}
