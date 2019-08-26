package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/23 18:43
 */
public class Ship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] weight = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            weight[i] = Integer.valueOf(s[i]);
        }
        int limit = sc.nextInt();

        Arrays.sort(weight);    // 从小到大
        int i = 0;
        int j = weight.length-1;
        int count = 0;
        while (i<j){
            if (weight[i]+weight[j]<=limit){
                i++;
                j--;
                count++;
            }else {
                j--;
                count++;
            }
        }
        if (i==j) count++;
        System.out.println(count);
    }
}
