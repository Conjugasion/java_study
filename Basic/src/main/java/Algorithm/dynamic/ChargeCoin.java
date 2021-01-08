package Algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019-07-28 21:45
 */
public class ChargeCoin {
    public static void main(String[] args) {
        int[] money = {5, 3, 6};
        int amount = 7;
        System.out.println(find(money, amount));
    }


    // i表示要找的金额，dp[i]表示需要的最小钞票数
    // dp[i] = min{dp[amount-面值1], dp[amount-面值2], dp[amount-面值3]......} + 1
    static int find(int[] money, int amount){
        if (amount==0) return 0;
        if(money.length==0) return -1;
        int[] dp = new int[amount+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {        // 依次寻找amount=0/1/2/3...的最少钞票数
            for (int j = 0; j < money.length; j++) {
                if (i>=money[j] && dp[i-money[j]]!=-1){      // 要求 i大于当前面值 && i-money[j]金额需要存在可行解
                    if (dp[i]==-1 || dp[i] > dp[i-money[j]]+1){    // 要求 i金额目前还没可行解 || i金额可行解较差
                        dp[i] = dp[i-money[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }
}
