package algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019-07-28 21:45
 */
public class ChargeCoin {
    public static void main(String[] args) {
        int[] money = {1, 3, 2};
        int amount = 8;
        System.out.println(find(money, amount));
    }


    // dp[i] = min(dp[i-1],dp[i-3],dp[i-2])+1
    // dp[i] 表示金额i的最优解
    static int find(int[] money, int amount){
        if (amount==0) return 0;
        if(money.length==0) return -1;
        for (int i:money) {
            if (i==amount){
                return 1;
            }
        }
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Math.min(Math.min(dp[i-1],dp[i-3]),dp[i-2]);
        }
        return dp[amount];
    }
}
