package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/17 19:37
 */
public class FindMinAB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long min = Long.MAX_VALUE;
        for (long i = 0; i < n; i++) {
            long one = n-i;
            long num = k/one;
            for (long j = m-num; j < m; j++) {
                min = Math.min(min, (i + j));
            }
        }
        System.out.println(min);
    }
}
