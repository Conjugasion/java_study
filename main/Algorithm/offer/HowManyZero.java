package Algorithm.offer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/18 12:45
 * 输入一个自然数n，求表达式 f(n) = 1!2!3!.....n! 的结果末尾有几个连续的0？
 *
 * 输入描述:
 * 自然数n
 *
 * 输出描述:
 * f(n)末尾连续的0的个数
 *
 * 输入例子1:
 * 11
 *
 * 输出例子1:
 * 9
 */
public class HowManyZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger sum = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            BigInteger jieCheng = jieCheng(i);
            System.out.println(i + "的阶乘是：" + jieCheng);
            sum = sum.multiply(jieCheng);
        }
        System.out.println("sum是：" + sum);

        ArrayList<BigInteger> nums = new ArrayList<>();
        do {
            nums.add(sum.mod(BigInteger.valueOf(10)));
            sum = sum.divide(BigInteger.valueOf(10));
        }while (!sum.equals(BigInteger.valueOf(0)));
        System.out.println(nums);

        int count = 0;
        for (BigInteger big:nums) {
            if (big.equals(BigInteger.valueOf(0))) count++;
            else break;
        }
        System.out.println(count);
    }

    static BigInteger jieCheng(int n){
        BigInteger sum = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            sum = sum.multiply(BigInteger.valueOf(i));
        }
        return sum;
    }
}
