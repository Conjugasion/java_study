package Algorithm.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 16:11
 */
public class matrixFind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                nums.add(i*j);
            }
        }
        Collections.sort(nums);
        System.out.println(nums.get(nums.size()-k));
    }
}
