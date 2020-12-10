package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-21 19:03
 * 最大化剩下的数
 */
public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        float[] array = new float[n];
        for (int i = 0; i < n; i++) {
            array[i] = (float) sc.nextInt();
        }
        Arrays.sort(array);
        float[] copy = Arrays.copyOfRange(array, 0, array.length);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length-1; i++) {
             array[i+1] = (array[i]+array[i+1])/2;

        }
        System.out.println(Arrays.toString(array));
        for (int i = copy.length-1; i >= 1; i--) {
            copy[i-1] = (copy[i]+copy[i-1])/2;
        }
        System.out.println(Arrays.toString(copy));
        String result1 = String.format("%.4f",array[array.length-1]);
        String result2 = String.format("%.4f",copy[0]);

        System.out.println(result1);

        System.out.println(result2);

    }
}
