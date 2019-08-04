package Algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019/7/30 21:23
 * 已知一个未排序的数组，求这个数组的最长上升子序列
 * 例如1,3,2,3,1,4, 最长子序列为1,2,3,4
 * 2 1 4 3 6 5 6
 */
public class LongestIncreaseStr {
    public static void main(String[] args) {
        int[] str = {2,1,4,3,6,5,1};
        System.out.println(find(str));
    }

    // dp[i]表示以第i个数字结尾的 最长上升子序列
    // dp[i] = max(dp[0], dp[1],...,dp[i-1])+1, 如果str[i]>str[0]/str[1]/.../str[i-1]
    static int find(int[] str){
        int[] dp = new int[str.length];
        dp[0] = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < str.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (str[i]>str[j]){
                    max = max >= dp[j] ? max : dp[j];
                }
            }
            dp[i] = max + 1;
            result = result >= dp[i] ? result : dp[i];
        }
        return result;
    }
}
