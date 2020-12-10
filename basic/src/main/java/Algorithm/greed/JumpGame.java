package Algorithm.greed;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lucas
 * @date 2019-08-03 14:14
 * 一个数组存储了非负整数，num[i]表示可以从数组第i个位置最多向前跳跃num[i]步
 * 问 是否可以从数组第0个位置跳跃到数组的最后一个位置
 * 2,3,1,1,4 可以跳跃到最后一个位置
 * 3,2,1,0,4 不可以
 */
public class JumpGame {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 3; i < 15; i++) {
            int[] nums = new int[i];
            for (int j = 0; j < i; j++) {
                nums[j] = random.nextInt(7);
            }
            System.out.println(Arrays.toString(nums));
            boolean[] dp = new boolean[nums.length];
            findByDynamic(nums, nums.length-1, dp);
            System.out.println("递归de方法：" + dp[0]);
            int[] count = new int[1];
            System.out.println("贪心法：" + findGreed(nums, count) + " 一共跳跃" + count[0] + "次");
            System.out.println("-------------");
        }
    }

    // 首先寻找一次能跳到最后一个位置的地方，然后以此为最后一个位置，寻找一次能跳到该点的位置......
    static boolean findByDynamic(int[] nums, int aim, boolean[] dp){
        if (nums.length==0||nums.length==1) return true;
        if (aim==0) return true;
        for (int i = 0; i <= aim; i++) {
            if (nums[i] >= aim-i && !dp[i]) {
                dp[i] = true;
                findByDynamic(nums, i, dp);
            }
        }
        return false;
    }

    // 跳每一步的性价比= nums[i] + i, 每次选择跳性价比最高的
    // count[0] 保存最少跳跃几次
    static boolean findGreed(int[] nums, int[] count){
        if (nums.length==0||nums.length==1) return true;
        if (nums[0]==0) return false;
        int cur = 0;
        int best = -1;      // 初始化下一步的最佳跳跃点
        while (best!=0){    // 一旦没找到最佳跳跃点，则没必要要循环了
            best = 0;
            for (int i = cur+1; i <= cur+nums[cur]; i++) {
                if (i<nums.length-1){
                    best = (nums[best] + best) >= (nums[i] + i) ? best : i;
                }else {
                    count[0]++;
                    return true;
                }
            }
            if (best!=0) {
                count[0]++;
                cur = best;
            }
        }
        count[0]=0;
        return false;
    }
}
