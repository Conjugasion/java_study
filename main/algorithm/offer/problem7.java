package algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-29 21:50
 * 斐波那契数列
 * 调用次数 是 f(n-1)次+f(n-2)次+1
 */
public class problem7 {
    /*
    递归版
     */
    static long Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return Fibonacci(n - 1)+Fibonacci(n - 2);
    }
    /*
    记忆递归型(用一个数组保存中间值)
     */
    static long Fibonacci(int n, long[] midResult){
        if (midResult[n] != 0){
            return midResult[n];
        }
        if (n==0){
            midResult[0] = 0;
        }
        else if (n==1){
            midResult[1] = 1;
        }
        else {
            midResult[n] = Fibonacci(n -1, midResult)+Fibonacci(n-2, midResult);
        }
        return midResult[n];
    }

    /*
    递推型
     */
    static long Fibonacci(long[] midResult, int n){
        for (int i = 0; i <= n; i++) {
            if (i==0){
                midResult[0] = 0;
            }
            else if (i == 1){
                midResult[i] = 1;
            }
            else {
                midResult[i] = midResult[i-1] + midResult[i-2];
            }
        }
        if (n==0){
            return 0;
        }
        else if (n==1){
            return 1;
        }
        else {
            return midResult[n-1] + midResult[n-2];
        }
    }

    public static void main(String[] args) {
        //System.out.println(Fibonacci(100));
        long[] midResult = new long[40];
        System.out.println(Fibonacci(39, midResult));
        System.out.println(Fibonacci(midResult, 39));
    }
}
