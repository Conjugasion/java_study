package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-28 17:27
 *
 */
public class OJInput {
    public static void main(String[] args) {
        // function1();
        // function2();
        // function3();
        function4();
    }


    // * 输入数据包括多组。
    // * 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
    // * 接下来n个正整数,即需要求和的每个正整数。
    // * 输出描述:
    // * 每组数据输出求和的结果
    // * 输入
    // * 复制
    // * 4 1 2 3 4
    // * 5 1 2 3 4 5
    // * 0
    static void function1(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n==0) break;
            int sum = 0;
            for(int i=0;i<n;i++){
                sum += sc.nextInt();
            }
            System.out.println(sum);
        }
    }


    //对输入的字符串进行排序后输出
    //输入描述:
    //输入有两行，第一行n
    //
    //第二行是n个空格隔开的字符串
    //输出描述:
    //输出一行排序后的字符串，空格隔开，无结尾空格
    //示例1
    //输入
    //5
    //c d a bb e
    // 输出
    //a bb c d e
    static void function2(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.next();
        }
        Arrays.sort(str);
        for (String s:str) {
            System.out.print(s + " ");
        }
    }


    //多个测试用例，每个测试用例一行。
    //
    //每行通过空格隔开，有n个字符，n＜100
    //输出描述:
    //对于每组测试用例，输出一行排序过的字符串，每个字符串通过空格隔开
    //示例1
    //输入
    //a c bb
    //f dddd
    //nowcoder
    //输出
    //a bb c
    //dddd f
    //nowcoder
    static void function3(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            String[] str = s.split(" ");
            Arrays.sort(str);
            for(int i=0;i<str.length-1;i++){
                System.out.print(str[i] + " ");
            }
            System.out.println(str[str.length-1]);     // 将光标移到下一行开始，便于下次输入
        }
    }


    //输入有多组测试用例，每组空格隔开两个整数
    //输出描述:
    //对于每组数据输出一行两个整数的和
    //示例1
    //输入
    //1 1
    //输出
    //2
    static void function4(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext() /* sc.hasNextLong() */){
            long a = sc.nextLong();
            long b = sc.nextLong();
            System.out.println(a+b);
        }
    }
}
