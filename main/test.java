import org.junit.Test;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther Lucas
 * @date 2018/12/28 9:16
 */
public class test {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你的姓名：");
//        String name = sc.nextLine();
//        System.out.println("请输入你的性别：");
//        String sex = sc.nextLine();
//        System.out.println("请输入你的年龄：");
//        int age = sc.nextInt();
//        System.out.println("请输入你的工资：");
//        float salary = sc.nextFloat();
//        System.out.println("你的信息如下：");
//        System.out.println("姓名："+name+"\n"+"性别："+sex+"\n"+"年龄："+age+"\n"+"工资："+salary);

//        System.out.println("---->Test1:");
//        Scanner scanner = new Scanner(System.in);
//        int nextStr = scanner.nextInt();
//        System.out.println("scanner.nextInt()得到：" + nextStr);
//        String nextlineStr = scanner.nextLine();
//        System.out.println("scanner.nextLine()得到：" + nextlineStr);

//        System.out.println("\n---->Test2:");
//        String nextlineStr2 = scanner.nextLine();
//        System.out.println("scanner.next()得到：" + nextlineStr2);
//        String nextStr2 = scanner.next();
//        System.out.println("scanner.next()得到：" + nextStr2);
//    }

    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("请输入数字：");
        br.readLine();
        System.out.println("请再输入数字：");
        String[] numss = br.readLine().split(" ");
        System.out.println(Arrays.toString(numss));
    }
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
        String s = "Asdfg";
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars){
            if(97 <= c && c <= 122){
                String s1 = Character.toString(c);
                sb.append(s1.toUpperCase());
            }
            else if(65 <= c && c <= 90) {
                sb.append((char)(c + 32));
            }
        }
        System.out.println("大写变小写，小写变大写: " + sb);
    }

    @Test
    public void test6(){
        StringBuilder sb = new StringBuilder();
        sb.append('c');
        System.out.println(sb);
    }

    @Test
    public void test7(){
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(3);
        a.add(6);

        Integer[] c = new Integer[a.size()];
        Integer[] b = a.toArray(c);
        System.out.println(Arrays.toString(b));

        a.sort((i1,i2) -> i2.compareTo(i1));
        System.out.println(a);

        int[] arr=new int[6];
        int intValue=arr[5];
        System.out.println(intValue);

    }

    @Test
    public void test9() throws IOException {
        List<String> list = new ArrayList<>(2);
        System.out.println("list大小为：" + list.size());
        list.add("12");
        System.out.println("list大小为：" + list.size());
//        list.set(1,"sss");
        list.add(1,"放在下标为1的位置");
        list.add("22");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
        list.add(1,"放在下标为1的位置");
        System.out.println("list大小为：" + list.size());
        System.out.println(list.toString());
//        ArrayList<String> list = new ArrayList<String>();
//        list.add("0");
//        list.add("1");
//        list.add("2");
//        list.clear();
//        System.out.println(list);
    }
    @Test
    public void test10(){
        System.out.println(getValue(2));
    }
    public static int getValue(int i) {
        int result = 0;
        switch (i) {
            case 1:
                result = result + i;
            case 2:
                result = result + i * 2;
            case 3:
                result = result + i * 3;
            case 4:
                result = result + i * 4;
        }
        return result;
    }

    @Test
    public void test11(){
        System.out.println(Integer.parseInt("0011",8));
        int i = 0;
        for ( foo('A'); foo('B') && (i < 2); foo('C'))
        {
            i++ ;
            foo('D');
        }
    }

    static boolean foo(char c)
    {
        System.out.print(c);
        return true;
    }

    @Test
    public void test12(){
        String s = null;
//        if( (s!=null) & (s.length() > 0)){
//            System.out.println(1);
//        }
        if( (s!=null) && (s.length() > 0)){
            System.out.println(1);
        }
        if( (s==null) | (s.length() == 0)){
            System.out.println(1);
        }
        if( (s==null) || (s.length() == 0)){
            System.out.println(1);
        }
    }

    @Test
    public void test13(){
        String a = "a" ;
        String b = new String("a");
        if (a.equals(b)){
            System.out.println("a.equals(b)");
        }

        if (a == b){
            System.out.println("a==b");
        }

        int c[] = new int[10];
    }

    @Test
    public void test14(){
        char[] c = {'a','b'};
        System.out.println(new String(c));

        int i = 0;
        int j = 0;
        if(++i >= 0){
            System.out.println(i);
        }

        class two{
            Byte b;
        }
        System.out.println((new two().b + " "));
        
        Lock l = new ReentrantLock();
        // Future f =

        List<Integer> link = new LinkedList<>();
        link.add(1);
        link.set(0, 11);
        System.out.println(link);


    }
}
