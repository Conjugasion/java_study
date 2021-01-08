package Algorithm.seach;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-08-11 12:10
 * 已知一个数组保存了n个火柴棍，问是否可以使用这n个火柴棍组成一个正方形
 * [1,1,2,2,2] true
 * [3,3,4,4,4] false
 * [1,1,2,4,3,2,3] true
 *
 * 数组sum%4==0；从大到小排序，先摆放大的，再摆放小的；
 */
public class CanComposeSquare {
    public static void main(String[] args) {
        boolean b = makeSquare(new int[]{1,1,2,2,2});
        System.out.println(b);
    }


    static boolean makeSquare(int[] nums){
        if (nums.length < 4){
            return false;
        }
        int sum = 0;
        for (int i:nums) {
            sum += i;
        }
        if (sum%4!=0){
            return false;
        }
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;j--;
        }
        // 四条边相当于四个桶
        int[] bucket = new int[4];
        return generate(0, nums, sum/4, bucket);
    }

    // i表示已放置了几根火柴棍
    static boolean generate(int i, int[] nums, int target, int[] bucket){
        if (i==nums.length){
            return bucket[0]==target && bucket[1]==target && bucket[2]==target && bucket[3]==target;
        }
        for (int j = 0; j < 4; j++) {    // 4个桶分别尝试
            if (bucket[j] + nums[i] > target) continue;
            bucket[j] += nums[i];    // 放在j桶中
            if (generate(i+1, nums, target, bucket)){
                return true;
            }else {
                bucket[j] -= nums[i];   // 回溯，拿出之前放入的nums[i]
            }
        }
        return false;
    }
}
