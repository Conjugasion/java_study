import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;


/**
 * @auther Lucas
 * @date 2018/12/28 9:16
 */
@Ignore("ignore this method")
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

    public static Logger logger = Logger.getLogger(test.class);

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
        String strTest = "test.java";

        // 匹配后缀
        Boolean b1 = str.endsWith(".java");
        System.out.println("b1 =" + b1);

        //匹配开头
        Boolean b2 = str.startsWith("test");
        System.out.println("b2 =" + b2);

        // 从指定位置匹配  false
        Boolean b3 = str.startsWith("est",2);
        System.out.println("b3 =" + b3);

        // 是否包含指定字符串
        Boolean b4 = str.contains("t.");
        System.out.println("b4 =" + b4);

        // 查找一个字符，在字符串中第一次出现的索引
        System.out.println("indexOf: " + str.indexOf("a"));
        System.out.println("indexOf: " + str.indexOf("test"));

        // String字符串转成字节数组
        byte[] bytes = str.getBytes();
        System.out.println("bytes = " + Arrays.toString(bytes));

        // String字符串转成字符数组
        char[] chars = str.toCharArray();
        System.out.println("chars = " + Arrays.toString(chars));

        String str1 = str.replace("t","T");
        System.out.println("replace: " + str1);

        String str2 = str.replaceAll("t{2}","T");
        System.out.println("replaceAll: " + str2);

        // compareTo
        System.out.println("compareTo: " + "bbc".compareTo("bac"));     // ascii差
        System.out.println("compareTo: " + "abcde".compareTo("abc"));   // 返回长度差

        //concat
        System.out.println("concat: " + "abc".concat("def"));

        //copyValueOf
        System.out.println("copyValueOf: " + String.copyValueOf(new char[]{'a','b','c'}, 1, 1));

        //join
        System.out.println("join: " + String.join("&", "a", "s", "d"));
        System.out.println("join: " + String.join("$", new ArrayList<String>(){{add("a");add("s");add("d");}}));
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

    /**
     * 条件断点
     */
    @Test
    public void test15(){
        int j = 0;
        for (int i = 0; i < 100; i++) {
            if (i==51&& j==0){
                System.out.println(51);
            }
        }
    }

    @Test
    public void test16(){
        boolean[][] a = new boolean[10][10];
        boolean b[][] = new boolean[20][20];
        a[0][0] = false;
        b[0][0] = true;
        System.out.println(b[0][0]);
        logger.debug("debug");

        boolean c = false;
        boolean d = true;
        c |= d == true;
        System.out.println(c);
        int e = 1;
        int f = 0;
        f += e++;
        int h = 1;
        int g = 0;
        g += ++h;
        System.out.println("f= " + f);
        System.out.println("g= " + g);
    }

    @Test
    public void test17(){
        double[] d = new double[3];  // 0.0
        System.out.println(d[0]);

        float[] f = new float[3];  // 0.0
        System.out.println(f[0]);

        System.out.println(d[0]==f[0]); // true
    }

    @Test
    /*
    基本数据类型转型
     */
    public void test18(){
        byte a1 = 0;
        byte a2 = 1;
        byte a3, a4;

        char c1 = 2;
        char c2 = 3;
        char c3;

        short d1 = 4;
        short d2 = 5;
        short d3;

        float e1 = 6;
        float e2 = 7;
        float e3;

        double f1 = 8;
        double f2 = 9;
        double f3;

        long g1 = 10;
        long g2 = 11;
        long g3;

        int h1 = 12;
        int h2 = 13;
        int h3;


        /*a3 = a1 + a2;
        c3 = c1 + c2;
        d3 = d1 + d2;*/

        int i = a1 + a2;    // byte char short 之间相加减， 都转型成int. int可以向上转
        int i1 = c1 + c2;
        int i2 = d1 + d2;
        int i3 = a1 + c1;
        long i4 = a1 + d1;
        float i5 = c1 + d1;


        e3 = e1 + e2;       // float double long 自己相加减，所得结果是自己类型
        f3 = f1 + f2;
        g3 = g1 + g2;

        float v = a1 + e1;    // 以精度高的数据为准
        double v1 = e1 + f1;
        long l = g1 + a1;
        float v2 = h1 + e1;   // 以浮点数为准
        double v3 = g1 + f1;
        float v4 = g1 + e1;

        final byte a5 = 120;
        final byte a6 = 7;
        byte a7 = a5 + a6;

        final char c4 = 58;
        final char c5 = 15;

        final long l2 = 10;
        final int i8 = 10;
        final float f4 = 10;

        byte a8 = a6 + c4;
        char c6 = a6 + c4;
        short i6 = a5 + c4;
        float i7 = a5 + c4;
        /*byte a9 = a6 + l2;*/
        byte a10 = a6 + i8;
        float a11 = a6 + f4;
        byte i9 = c4 + i8;

        System.out.println(c6);
        System.out.println(i6);

        final float e4 = 16;

        float v5 = a6 + e4;

    }

    /*
    类的向上 向下转型
     */
    @Test
    public void test19(){
        abstract class father{
            public father(){}
        }
        class mather{
            public mather() {}
        }
         final class son extends mather{
            public son(){}
        }

        mather m1 = new mather();
        son s1 = new son();

        /*son s2 = m1;*/   // 从大变小，要强转
        mather m2 = s1;    // 从小变大，不需要强转

        mather s3 = new son();
        mather m3 = s3;
        son s4 = (son)s3;

        short s = 10;
        int i = s;

        byte b = 10;
        /*char c = b;*/   // char没有负值，byte有负值，不能自动转换
        short k = b;
        short d = b;
        short e = 10;
        /*char f = e;*/  // char没有负值，short有负值，不能自动转换
        char f = 10;
        /*byte b1 = f;*/
       /* short g = f;*/

        final byte h = 10;
        char j = h;
    }

    /*
    数组、list和map的排序
     */
    @Test
    public void test20(){
        Map<String, String> map1 = new HashMap();
        map1.put("six","6");
        map1.put("one","1");
        map1.put("four","4");
        map1.put("two","2");
        map1.put("five","5");
        map1.put("three","3");

        ArrayList<Map.Entry<String, String>> entryList = new ArrayList<>(map1.entrySet());

        Collections.sort(entryList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        System.out.println("ArrayList根据value从小到大排序");
        for (Map.Entry<String, String> e : entryList) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        System.out.println("ArrayList根据value从大到小排序");
        entryList.sort(new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return 0;
            }
        });
        for (Map.Entry<String, String> e : entryList) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        System.out.println("string's compareTo");
        String s1 = "string";
        String s2 = "strinh";
        System.out.println(s1.compareTo(s2));


        Integer[] array = {5, 4, 12, 3, 1};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -2;
                }
                else if (o1 < o2){
                    return 2;
                }
                else
                    return 0;
            }
        });
        System.out.println("重写数组sort的Comparator方法，从大到小排序");
        System.out.println(Arrays.toString(array));

        LinkedList<Integer> link = new LinkedList<>(Arrays.asList(new Integer[]{2, 3, 4, 1, 4, 7}));
        Collections.sort(link);
        System.out.println("Collections.sort(link): " + link);
        Collections.sort(link, Collections.reverseOrder());
        System.out.println("Collections.sort(link, Collections.reverseOrder()): " + link);
        link.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -2;
                }
                else if (o1 < o2){
                    return 2;
                }
                else
                    return 0;
            }
        });
        System.out.println("LinkedList.sort()自定义排序 从大到小排序: " + link);
    }
    /*
    TreeMap
     */
    @Test
    public void test21(){
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        treeMap.put("six","6");
        treeMap.put("one","1");
        treeMap.put("four","4");
        treeMap.put("two","2");
        treeMap.put("five","5");
        treeMap.put("three","3");
        System.out.println(treeMap);
    }
    /*
    compile、pattern
     */
    @Test
    public void test22(){
        String pid = "mallocw: initialized with features=0 2945";
        String[] pidStr = Pattern.compile(" ").split(pid);
        System.out.println(pidStr[pidStr.length-1]);

        char[] chars = pid.toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i] != ' '){
                result.append(chars[i]);
            }
            else break;
        }
        System.out.println(result.reverse());

        if (false && true || true && false){
            System.out.println("-------------");
        }
        System.out.println(~2);  // 2在计算机中存储是0 010（补码） 取反得到1 101也是补码，输出需要源码，1 101->1 100->1 011

        Integer a = -128;   // -128 ~ 127 均相等
        Integer b = -128;
        System.out.println(a==b);

        int i = 1;
        int j = 2;
        System.out.println(i++*5 + ++j*5); // i++ 先用后加，++j 先加后用   5 + 15
        System.out.println(i);  // 2
        System.out.println(j);  // 2

        // ++x*++y
        int x = 3;
        int y = 5;
        int z = ++x*++y;  // 4*6
        System.out.println("z= " + z);
    }
}
