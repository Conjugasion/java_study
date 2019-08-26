import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * @auther Lucas
 * @date 2018/12/28 9:16
 */
@Ignore("ignore this method")
public class test {

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
        logger.debug("Debug");

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
                return o1.compareTo(o2);
                //return -1;
            }
        });
        treeMap.put("six","6");
        treeMap.put("one","1");
        treeMap.put("four","4");
        //treeMap.put("four","5");
        treeMap.put("two","2");
        treeMap.put("five","5");
        treeMap.put("three","3");
        treeMap.keySet();
        Stack<Integer> stack = new Stack<>();
        
        System.out.println(treeMap);   // six=3
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

        Character c1 = 127;
        Character c2 = 127;
        System.out.println(c1==c2);
    }

    @Test
    /*
    十进制转二进制
    不带加号的加法
     */
    public void test23(){
        int a = 10;
        int b = 0;
        StringBuilder str = new StringBuilder();

        while (true){
            if (a == 0){
                break;
            }
            b = a%2;
            a = a/2;
            str.append(b);
        }
        int num =  Integer.valueOf(str.reverse().toString());

        int c = 5;
        int d = 8;

        while (true){
            int num1 = (c^d);  // 不带进位的加法
            int num2 = (c&d) << 1;   // 进位

            if (num2 == 0){
                System.out.println(num1);
                break;
            }
            else {
                c = num1;
                d = num2;
            }
        }

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("a");
        list1.add(null);
        System.out.println("list1: " + list1);
        list1.replaceAll(x -> x+1);
        System.out.println(list1);

        Collections.replaceAll(list1, "a1", "A1");
        System.out.println(list1);

        Integer[] array = {9,1,8,2,7,3,4,6,5};
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(array));
        Arrays.sort(array);
        Collections.sort(list2);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println(list2);
        String s = "#"+2+"" +1+""+2+"#";
        String[] split = s.split("2");
        System.out.println(Arrays.toString(split));
        System.out.println(Integer.toBinaryString(-1));

        int[] seq = new int[]{3,1,2};
        int[] copy = Arrays.copyOfRange(seq,0,seq.length);
        System.out.println(Arrays.toString(seq));
        Arrays.sort(seq);
        int i = 0;
        for (; i < 3; i++) {
            System.out.println(i);
        }

        System.out.println("ab"+'c');
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Iterator<String> iterator = list1.iterator();
        ArrayList<String> str1 = new ArrayList<>();
        str1.add("3");
        str1.add("4");
        str1.add("34");
        str1.add("32");
        str1.add("43");
        str1.add("342");
        str1.add("5");
        str1.addAll(5,str1);      // 指定插入的索引位置
        System.out.println("addAll: " + str1);
        Collections.sort(str1);
        System.out.println("Collections sort: " + str1);
        System.out.println("Collections binarySearch: " + Collections.binarySearch(str1, "342"));

        String[] str2 = {"3","4","34","32","43","342","5"};
        Arrays.sort(str2);
        System.out.println(Arrays.toString(str2));

        // array必须是Integer[]，而不是int[]
        Arrays.sort(array, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                if (Integer.valueOf(String.valueOf(o1)+String.valueOf(o2)) < Integer.valueOf(String.valueOf(o2)+String.valueOf(o1))){
                    return -1;
                }
                else return 1;
            }
        });
        StringBuilder builder = new StringBuilder();
        for(int in:array){
            builder.append(in);
        }
    }

    @Test
    public void test24(){
        HashSet<Long> sortSet = new HashSet<>();
        sortSet.add(2L);
        sortSet.add(6L);
        sortSet.add(1L);
        System.out.println("初始打印顺序: " + sortSet);
        ArrayList<Long> setList = new ArrayList<>(sortSet);
        System.out.println("set转list之后的顺序: " + setList);
        //setList.addAll(sortSet);
        String num = String.valueOf(setList.get(0));
        System.out.println(Integer.valueOf("29296875"));


        // 移除指定元素 要用包装类！！！不然默认为删除指定索引。
        new ArrayList<Integer>().remove((Integer) 1);

        // 引用类型数组转ArrayList比较方便
        String[] str = {"a","b"};
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println("list: " + list);

        // 基本类型 比如int long double数组转ArrayList比较麻烦，用Stream/遍历
        int[] array = {1,2,3,2};
        List<Integer> integers= IntStream.of(array).boxed().collect(Collectors.toList());
        //ArrayList<Integer> integers= (ArrayList)IntStream.of(array).boxed().collect(Collectors.toList());
        //new HashSet<Integer>().removeAll()
        ArrayList<Integer> removedList = new ArrayList<>();
        removedList.add(2);
        HashSet<Integer> removedSet = new HashSet<>();
        removedSet.add(2);
        //integers.removeAll(removedList);     // 移除所有removed包含的元素，包括重复和不重复元素
        integers.removeAll(removedSet);     // 移除所有removed包含的元素，包括重复和不重复元素
        //integers.remove((Integer)2);       // 仅移除一个
        System.out.println("integers: " + integers);
    }

    // set集合并、差、交
    @Test
    public void test25(){
        Set<Integer> result = new HashSet<>();
        Set<Integer> set1 = new HashSet<Integer>(){{
            add(1);
            add(3);
            add(5);
        }};

        Set<Integer> set2 = new HashSet<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};

        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集："+result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集："+result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集："+result);
        result.contains(1);
    }

    //
    @Test
    public void test26(){
        char[] chars = {'a','b','c','d','e'};
        //String s = new String(chars);
        String s = String.valueOf(chars);
        System.out.println("String's subString: " + s.substring(1,3));    // 包头不包尾 bc
        System.out.println("StringBuilder's subString: " + new StringBuilder(s).substring(1,3));
        String[] str = {"a","b","c"};
        System.out.println("String[]转String: " + String.join("", str));  // String[]转String

        // 翻转单词顺序
        String word = "student. a am I";
        String[] strs = word.split(" ");
        int i=0;
        int j=strs.length-1;
        while (i<=j){
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
            i++;
            j--;
        }
        System.out.println(String.join(" ", strs));
        String badStr1 = "";
        String badStr2 = " ";
        //badStr1' isEmpty: true,badStr1' length: 0
        //badStr2' isEmpty: false,badStr2' length: 1
        System.out.println("badStr1' isEmpty: " + badStr1.isEmpty() + ",badStr1' length: " + badStr1.length());
        System.out.println("badStr2' isEmpty: " + badStr2.isEmpty() + ",badStr2' length: " + badStr2.length());
        Arrays.sort(new int[]{1,2,3});
    }

    @Test
    public void test27(){
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list3.add(1);
        arrayLists.add(list1);
        arrayLists.add(list2);
        arrayLists.add(list3);
        Collections.reverse(list2);
        System.out.println("list2翻转: " + list2);
        System.out.println("index: " + list2.indexOf(2));
        System.out.println("不存在元素的index: " + list2.indexOf(4));

        System.out.println(arrayLists);
        arrayLists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });
        System.out.println("按长度排序: " + arrayLists);

        System.out.println(Integer.valueOf("11111111111111111111111"));
        System.out.println(Integer.MIN_VALUE);

    }

    // 正则匹配
    @Test
    public void test28(){
        //Pattern pattern = Pattern.compile("ab*ac*a");     // true
        //Pattern pattern = Pattern.compile("aa.a");        // false
        Pattern pattern = Pattern.compile("");              // true
        //Pattern pattern = Pattern.compile(".");              // true
        Matcher matcher = pattern.matcher("aaa");
        System.out.println(matcher.find());

        //Pattern pattern2 = Pattern.compile(" aaa ");
        //Matcher matcher2 = pattern2.matcher("aaa");         // false
        Pattern pattern2 = Pattern.compile(".");
        Matcher matcher2 = pattern2.matcher(" ");        // true
        System.out.println(matcher2.matches());

        Pattern pattern3 = Pattern.compile("");
        Matcher matcher3 = pattern3.matcher("1e-1");
        System.out.println("是不是数字：" + matcher3.matches());
        Exception ioException = new IOException();
        Exception e = new Exception();
        boolean signalm,decimal = false;                      // 同时定义多个变量
        System.out.println(decimal);
        System.out.println("是不是数字：" + Float.valueOf("-1E-16"));
        for (int i =0 ,j = 0; i!=8 ; i++,j+=2) {
            System.out.println("i: " + i + ", j: " + j);
        }
        LinkedList<String> list = new LinkedList<>();
        String s = null;
        list.offer(s);       // 非空
        if (!list.isEmpty()){
            System.out.println("list isn't empty");
        }
        System.out.println(new StringBuilder());
        System.out.println('1'-48);
        System.out.println(Float.valueOf("12.123"));

        String s2 = " ";
        if (s2.trim().isEmpty()){
            System.out.println("s2 is empty");
        }
    }

    @Test
    public void test29(){
        int[] a = {2,1,4,6,0,9,3};
        Arrays.sort(a, 2,5);     // 包头不包尾
        System.out.println(Arrays.toString(a));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        minHeap.offer(5);
        minHeap.offer(8);
        minHeap.offer(1);
        minHeap.remove(1);
        System.out.println(minHeap.peek());
        while (!minHeap.isEmpty()){
            System.out.print(minHeap.poll());
        }
        System.out.println("");
        TreeSet<Integer> treeSet = new TreeSet();
        treeSet.add(5);
        treeSet.add(8);
        treeSet.add(1);
        for (int i:treeSet) {
            System.out.print(i + " ");
        }
        int[] ints = Arrays.copyOfRange(a, 1, 1);  // []
        System.out.println(ints.length);

        String str = "charAt";
        System.out.println(str.charAt(1));    // h
        StringBuilder stringBuilder = new StringBuilder("charAt");
        stringBuilder.setCharAt(1,'H');    // cHarAt
        System.out.println(stringBuilder);
        stringBuilder.replace(2,3,"A");   // cHArAt
        System.out.println(stringBuilder);
        stringBuilder.insert(1,"C");
        System.out.println(stringBuilder);    // cCHArAt
        char[] test = new char[4];
        test[0] = '0';
        stringBuilder.getChars(1,4,test,1);   // 0CHA
        System.out.println(test);
    }

    @Test
    public void test30() throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> test = loader.loadClass("test");
        System.out.println(test);

        // 队列！
        /*
        1.获取并移除
        poll() 　　获取并移除此队列的头，如果此队列为空，则返回 null
        remove()　　获取并移除此队列的头，如果此队列为空，则抛出NoSuchElementException异常

        2.获取但不移除
        peek()　　获取队列的头但不移除此队列的头。如果此队列为空，则返回 null
        element()　　获取队列的头但不移除此队列的头。如果此队列为空，则将抛出NoSuchElementException异常

        3.添加元素的方法
        offer()　　将指定的元素插入此队列（如果立即可行且不会违反容量限制），插入成功返回 true；否则返回 false。
        当使用有容量限制的队列时，offer方法通常要优于 add方法——add方法可能无法插入元素，而只是抛出一个IllegalStateException异常
        add()　　将指定的元素插入此队列
         */
        Queue<Object> queue = new LinkedList<>();
        queue.offer(1);      // 队头
        queue.offer(2);
        queue.offer(3);      // 队尾
        System.out.println(queue.element());
        System.out.println(queue.peek());

        int i = 10000;
        Integer j = new Integer(10000);
        System.out.println(i==j);    // 自动装箱、拆箱

        String s = String.format("数字是%#X和%.2fs", 10, 20.0);   // 数字是0XA和20.00s
        System.out.println(s);
        System.out.println((((long)Math.pow(2, 58-1))*80)/(((long)Math.pow(2,58))-1));
        // System.out.println(new BigInteger(String.valueOf(Math.pow(2, 58-1)*80)));

        String string = Integer.toBinaryString(-3);
        System.out.println(string);         // 负数输出补码形式

        System.out.println('c'-'a');
        System.out.println(Math.sqrt(4.0));
        System.out.println((2.0-2)==0);

        ArrayList<Object> arr1 = new ArrayList<>();
        ArrayList<Object> arr2 = new ArrayList<>();
        arr1.add(1);
        arr1.add(1);
        arr1.add(1);
        arr2.add(1);
        arr1.remove((Integer)1);
        System.out.println(arr1);
    }
}
