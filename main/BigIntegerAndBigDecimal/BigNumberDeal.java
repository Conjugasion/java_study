package BigIntegerAndBigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigDecimal.ROUND_DOWN;

/**
 * @author Lucas
 * @date 2019/8/17 13:10
 * 大数处理
 */
public class BigNumberDeal {
    public static void main(String[] args) {
        // base();
        // jieCheng();
        // pow();
        cal();
    }

    ///*
    // 大数的加减运算不同于普通整数的加减乘除运算
    // 加—— a+b: a=a.add(b);
    // 减—— a-b: a=a.subtract(b);
    // 乘—— a*b: a=a.multiply(b);
    // 除—— a/b: a=a.divide(b);
    // 求余—a%b: a=a.mod(b);
    // 转换—a=b: b=BigInteger.valueOf(a);
    // 比较 if (ans.compareTo(x) == 0)//比较
    static void base(){
        Scanner cin = new Scanner(System.in);
        BigInteger a,b,x,y;
        BigInteger ans_add,ans_sub,ans_mul,ans_div,ans_mod;
        a=cin.nextBigInteger();
        b=cin.nextBigInteger();
        ans_add = a.add(b); //a+b
        ans_sub = a.subtract(b); //a-b
        ans_mul = a.multiply(b); //a*b
        ans_div = a.divide(b); //a/b
        ans_mod = a.mod(b); //a%b
        x=BigInteger.valueOf(1);//转换
        System.out.println("a + b = "+ans_add);
        System.out.println("a - b = "+ans_sub);
        System.out.println("a * b = "+ans_mul);
        System.out.println("a / b = "+ans_div);
        System.out.println("a % b = " + ans_mod);
            System.out.println(x);
        if (a.compareTo(b) == 0)//比较
            System.out.println("相等");
        else
            System.out.println("不相等");
    }

    // 计算阶乘
    static void jieCheng(){
        Scanner in = new Scanner(System.in);
        int n;
        while (in.hasNext()) {
            n = in.nextInt();
            BigInteger sum = BigInteger.valueOf(1);
            for (int i = 1; i <= n; i++)
                sum = sum.multiply(BigInteger.valueOf(i));
            System.out.println(sum);
        }
    }

    // 计算a^b 注意是小数
    static void pow(){
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            BigDecimal a = input.nextBigDecimal(); // 大数类的double;
            int b = input.nextInt();
            a = a.pow(b);
            String ans = a.stripTrailingZeros().toPlainString(); // 去掉尾部零，转换成非科学计数法字符串
            /*if (ans.charAt(0) == '0') { // 如果以0开头, 0.25返回.25
                ans = ans.substring(1); // 返回以位置1开头的该字符串
            }*/
            System.out.println(ans);
        }
    }

    static void cal(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigDecimal m = sc.nextBigDecimal();
        System.out.println(m);

        BigDecimal radix = new BigDecimal(2);
        BigDecimal up = radix.pow(n-1).multiply(m);
        System.out.println(up);
        BigDecimal down = radix.pow(n).subtract(BigDecimal.valueOf(1));
        System.out.println(down);
        System.out.print(up.divide(down, 0, ROUND_DOWN));
    }
}
