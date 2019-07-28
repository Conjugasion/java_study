package algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019-07-28 21:20
 * 最大字段和，一个数组中，最大的那一段的和
 */
public class MaxStrSum {
    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(find(array));
    }

    // 以第n个数结尾的最大字段和(dp[n]) = ...
    // dp[n] = max{dp[n-1]+array[n], array[n]}
    static int find(int[] array){
        if (array.length==0) return 0;
        if (array.length==1) return array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];      // 寻找dp[i]中的最大值
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1]+array[i], array[i]);
            max = max >= dp[i] ? max : dp[i];
        }
        return max;
    }
}
