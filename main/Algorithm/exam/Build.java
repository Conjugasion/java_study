package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/17 21:26
 */
public class Build {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        if (n==1) {
            System.out.println(1);
        }else {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                if (i==0){
                    int curMax = height[1];
                    int count = 2;
                    for (int j = 2; j < n; j++) {
                        if (height[j]>curMax){
                            curMax = height[j];
                            count++;
                        }
                    }
                    result[i] = count;
                }else if (i==n-1){
                    int curMax = height[n-2];
                    int count = 2;
                    for (int j = n-3; j >=0; j--) {
                        if (height[j]>curMax){
                            curMax = height[j];
                            count++;
                        }
                    }
                    result[i] = count;
                }else {
                    int curMax1 = height[i+1];
                    int count1 = 2;
                    for (int j = i+1; j < n; j++) {
                        if (height[j]>curMax1){
                            curMax1 = height[j];
                            count1++;
                        }
                    }
                    int curMax2 = height[i-1];
                    int count2 = 1;
                    for (int j = i-2; j >=0; j--) {
                        if (height[j]>curMax2){
                            curMax2 = height[j];
                            count2++;
                        }
                    }
                    result[i] = count1 + count2;
                }

            }
            for (int i = 0; i < n; i++) {
                if (i==n-1){
                    System.out.print(result[i]);
                }else {
                    System.out.print(result[i] + " ");
                }

            }
        }

    }
}
