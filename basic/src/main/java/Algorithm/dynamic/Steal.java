package Algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019-07-28 21:01
 * [5,2,6,3,1,7] 只能从不相邻的位置选财宝，使财宝之和最大
 */
public class Steal {
    public static void main(String[] args) {
        int[] money = {5,2,6,3,1,7};
        int[] dp = new int[money.length];
        System.out.println(find(money));
    }
    // 前n个位置的最大财宝和(dp[n]) = ...
    // dp[n] = max(dp[n-2]+money[n],dp[n-1])
    static int find(int[] money){
        if (money.length==0) return 0;
        if (money.length==1) return money[0];
        if (money.length==2) {
            return money[0] >= money[1] ? money[0] : money[1];
        }
        int[] dp = new int[money.length];
        dp[0] = money[0];
        dp[1] = money[0] >= money[1] ? money[0] : money[1];
        for (int i = 2; i < money.length; i++) {
            dp[i] = Math.max(dp[i-2]+money[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
