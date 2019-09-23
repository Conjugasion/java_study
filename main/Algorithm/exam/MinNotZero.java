package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/20 21:22
 */
public class MinNotZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }
        for (int i = 0; i < k; i++) {
            method(nums);
        }
    }

    static void method(ArrayList<Integer> nums){
        int min = min(nums);
        System.out.println(min);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)!=0){
                nums.set(i, nums.get(i)-min);
            }
        }
    }

    // 返回最小值所在的索引
    static int min(ArrayList<Integer> nums){
        int min = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i)!=0) {
                flag = false;
                min = Math.min(nums.get(i), min);
            }
        }
        if (flag) return 0;
        else return min;
    }
}
