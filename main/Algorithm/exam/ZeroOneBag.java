package Algorithm.exam;

import java.util.Scanner;

import static Algorithm.dynamic.ZeroOneBag.maxValue;

/**
 * @author Lucas
 * @date 2019/8/20 19:43
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int value = maxValue(w, v, m);
        System.out.println(value);
    }
}
