package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-15 21:21
 */
public class RRLRRL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();    // RRRRRLRLRL
        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = 1;
        }
        for (int j = 0; j < 10000; j++) {
            int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='R') {
                    nums[i+1] = nums[i+1] + copy[i];
                    nums[i]  = nums[i] - copy[i];
                }else if (chars[i]=='L'){
                    nums[i-1] = nums[i-1] + copy[i];
                    nums[i]  = nums[i] - copy[i];
                }
            }
        }
        for (int i = 0; i < nums.length-1; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.print(nums[nums.length-1]);
    }
}
