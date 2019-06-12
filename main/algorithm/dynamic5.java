package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-06-09 17:22
 * 找零钱问题, 给定面值和aim，返回一共有几种组合方式
 * f[i][j] = f[i-1][j] + f[i][j-money[i]]
 */
public class dynamic5 {
    public static void main(String[] args) {
        int[] money = {5,10,25,1};
        int aim = 15;
        System.out.println(find(money, aim));
    }

    /*
    n种硬币组合成aim,有几种组合方式
     */
    static int find(int[] money, int aim){
        int[][] f = new int[money.length+1][aim+1];
        for (int i = 0; i <= aim; i++) {
            f[0][i] = 0;
        }
        for (int i = 0; i <= money.length; i++) {
            f[i][0] = 1;
        }

        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j>=money[i-1]){
                    f[i][j] = f[i-1][j] + f[i][j-money[i-1]];
                }
                else {
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[money.length][aim];
    }

    /*
    凑成aim的最少零钱数目
    f[i][j] = min{f[i][j], f[i][j-money[i]]+1}
     */
    static int find(int[] money, int aim, int[][] f){
      return 1;
    }
}











