package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2020/3/20 19:14
 */
public class DecreaseBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(sc.nextLine());
            result[i] = (int) (Math.floor(Math.log10(num)/Math.log10(2))+1);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
