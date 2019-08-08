package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019/8/7 12:09
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。
 * 现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * +1+1+1+1+1 = 5
 */
public class TargetSum2 {
    public static void main(String[] args) {
        System.out.println("动态规划：" + findTargetSumWays(new int[]{1,1,1,1,1}, 3) + "种方法");
        int[] count = new int[1];
        dfs(new int[]{1,1,1,1,1}, 3, count, 0, 0);
        System.out.println("dfs：" + count[0] + "种方法");
    }

    // sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
    // sum[P] + sum[N] = sum(nums)
    // sum[P] - sum[N] = target
    // 2*sum[P] = sum(nums) + target  偶数！
    static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i:nums) {
            sum+=i;
        }
        if ((sum+S)%2!=0 || S>sum) return 0;
        int w = (sum + S)/2;

        // 在nums中寻找任意元素，使之和等于w，共有多少种方法
        // dp[i] = dp[i-元素1] + dp[i-元素2] + dp[i-元素3] + ... + ...
        // dp[i] 表示和为i，最多有几种组合方法
        // 0/1背包
        int[] dp = new int[w+1];
        dp[0] = 1;          // S = -sum, 一个正数都没有

        /*
        第一次num1，仅仅更新了dp[num1] = 1，其他都是0+0都是0啊都是0
        第二次num2，更新了dp[num2] = 1和dp[num1+num2] = dp[num1+num2] + dp[num1] = 1,先更新后者。
        第三次num3，更新了dp[num3] = 1和dp[num1+num3] += 1和dp[num2+num3] += 1和dp[num1+num2+num3] += 1。
        按下标从大到小顺序来更新。
         */
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[w];
    }

    // 深度搜索
    static void dfs(int[] nums, int S, int[] count, int curCount, int curSum){
        if (curCount==nums.length){
            if (curSum==S) count[0]++;
            return;
        }
        dfs(nums, S, count, curCount+1, curSum+nums[curCount]);
        dfs(nums, S, count, curCount+1, curSum-nums[curCount]);
    }

}
