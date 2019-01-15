import org.junit.Test;

import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void test3(){
        String i = new String("123");
        String j = "123";
        System.out.println(i.equals(j));

        byte[] bytes = {-128,127,0};
    }

    @Test
    public void test4(){
        String str = "ttest.java";

        // 匹配后缀
        Boolean b1 = str.endsWith(".java");
        System.out.println(b1);

        //匹配开头
        Boolean b2 = str.startsWith("test");
        System.out.println(b2);

        // 从指定位置匹配
        Boolean b3 = str.startsWith("est",1);
        System.out.println(b3);

        // 是否包含指定字符串
        Boolean b4 = str.contains("t.");
        System.out.println(b4);

        // 查找一个字符，在字符串中第一次出现的索引
        System.out.println(str.indexOf("a"));

        // String字符串转成字节数组
        byte[] bytes = str.getBytes();

        // String字符串转成字符数组
        char[] chars = str.toCharArray();

        String str1 = str.replace("t","T");
        System.out.println(str1);

        String str2 = str.replaceAll("t{2}","T");
        System.out.println(str2);
    }

    @Test
    public void test5(){

    }
}
