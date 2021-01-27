/**
 * @author tangdongfan
 * @date 2021/1/26 16:16
 * @description 递归实现斐波那契数列Java版
 */

public class FibonacciJava {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        fib(50);
        long end = System.currentTimeMillis();
        System.out.println("斐波那契数列耗时: " + (end-start));
    }

    /**
     * 斐波那契数列
     */
    public static long fib(int n) {
        if (n==0) return 0;
        if (n==1 || n==2) return 1;
        return fib(n-1)+fib(n-2);
    }
}
