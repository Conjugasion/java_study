package Algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static Algorithm.dynamic.dynamic2.cut;

/**
 * @author Lucas
 * @date 2019/7/31 19:59
 * 切钢条，使得利润最大
 * 钢条长度 1 2 3 4 5  6  7  8  9  10
 * 钢条售价 1 5 8 9 10 17 17 20 24 30
 */
public class CutIronBar {
    public static void main(String[] args) {
        int[][] price1 = {{1,1},{2,5},{3,8},{4,9},{5,10},{6,17},{7,17},{8,20},{9,24},{10,30}};
        Map<Integer, Integer> price = new HashMap<>();
        price.put(1, 1);
        price.put(2, 5);
        price.put(3, 8);
        price.put(4, 9);
        price.put(5, 10);
        price.put(6, 17);
        price.put(7, 17);
        price.put(8, 20);
        price.put(9, 24);
        price.put(10, 30);

        for (int n = 0; n < 11; n++) {
            System.out.println("dp法获得的最大利润是 " + maxMoney(price1, n));
            System.out.println("递归法获得的最大利润是 " + cut(price, n));
            System.out.println("---------------------");
        }

    }

    // dp[i] = max{dp[i-1], dp[i-2], ... , dp[i-10]} + 对应的price[]
    // dp[i] 表示i长度的钢条能获得的最大利润
    // price = {{1,1},{2,5}, ... , {10,30}}
    static int maxMoney(int[][] price, int n){
        int[] dp = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < price.length; j++) {
                if (i >= price[j][0] && dp[i-price[j][0]] != -1){
                    if (dp[i]==-1 || dp[i-price[j][0]] + price[j][1] > dp[i]){
                        dp[i] = dp[i-price[j][0]] + price[j][1];
                    }
                }
            }
        }
        return dp[n];
    }
}
