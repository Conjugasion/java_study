package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-05-29 21:50
 * 斐波那契数列
 * 调用次数 是 f(n-1)次+f(n-2)次+1
 */
public class problem7 {
    public static int Fibonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return Fibonacci(n -1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(39));
    }
}
