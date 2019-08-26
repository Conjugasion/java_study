package Algorithm.dynamic;

import static Algorithm.dynamic.dynamic3.put;

/**
 * @author Lucas
 * @date 2019/7/31 20:46
 * 0/1背包问题
 */
public class ZeroOneBag {
    public static void main(String[] args) {
        int[] w = {11,4,5,6,2,2,2,1};  // 物品的重量
        int[] v = {100,6,4,5,3,6,1,5};  // 物品的价值
        int m = 10;                    // 背包容量

        for (int i = 0; i <= 15; i++) {
            System.out.println(i + "递归法0/1背包问题：" + put(i, w.length-1, w, v));
            System.out.println(i + "动态规划0/1背包问题：" + maxValue(w, v, i));
            System.out.println("---------------------");
        }
    }

    // dp[i][j]=max{dp[i-1][j],dp[i-1][j-c[i]]+w[i]}
    // dp[i][j] 表示将第n件物品放入背包能获得最大价值
    public static int maxValue(int[] w, int[] v, int m){
        int[][] dp = new int[w.length+1][m+1];
        // 初始化dp，i=0表示一件物品都不选，i=1表示将第1件物品放入背包
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (i==0) dp[i][j] = 0;
                else if (j==0) dp[i][j] = 0;
                else dp[i][j] = -1;
            }
        }

        int result =Integer.MIN_VALUE;
        /*for (int i = 1; i <= w.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j>=w[i-1] ){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + v[i-1]);
                }else dp[i][j] = dp[i-1][j];
                result = result >= dp[i][j] ? result : dp[i][j];
            }
        }*/

        for (int i = 0; i <= m; i++) {                // i指容量
            for (int j = 1; j <= w.length; j++) {     // 使用前j个物品
                if (i>=w[j-1]){
                    dp[j][i] = Math.max(dp[j-1][i], dp[j-1][i-w[j-1]] + v[j-1]);
                }else dp[j][i] = dp[j-1][i];
                result = result >= dp[j][i] ? result : dp[j][i];
            }
        }
        return result;
    }
}
