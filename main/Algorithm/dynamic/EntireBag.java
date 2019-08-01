package Algorithm.dynamic;


import static Algorithm.dynamic.dynamic4.put;

/**
 * @author Lucas
 * @date 2019/7/31 20:27
 * 完全背包问题
 */
public class EntireBag {
    public static void main(String[] args) {
        int[] w = {11,4,5,6,2,2,2,1};  // 物品的重量
        int[] v = {100,6,4,5,3,6,1,5};  // 物品的价值
        int m = 10;                    // 背包容量

        for (int i = 0; i <= 15; i++) {
            int[][] F = new int[w.length+1][i+1];
            System.out.println(i + "完全背包问题：" + put(i, w.length,w,v,F));
            System.out.println(i + "动态规划完全背包问题：" + maxValue(w, v, i));
            System.out.println("---------------------");
        }
    }

    // dp[i] = max{dp[i-1], dp[i-2], ... , dp[i-11]} + 对应的v[]
    // dp[i] 表示i容量下能获得的最大价值
    static int maxValue(int[] w, int[] v, int m){
        int[] dp = new int[m+1];
        for (int i = 0; i <= m; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < w.length; j++) {
                if (i>=w[j] && dp[i-w[j]] != -1){
                    if (dp[i] == -1 || dp[i-w[j]] + v[j] > dp[i]){
                        dp[i] = dp[i-w[j]] + v[j];
                    }
                }
            }
        }
        return dp[m];
    }
}
