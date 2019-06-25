package algorithm.dynamic;


/**
 * @author Lucas
 * @date 2019-06-09 17:22
 * 找零钱问题, 给定面值和aim，返回一共有几种组合方式
 * f[i][j] = f[i-1][j] + f[i][j-money[i]]
 */
public class dynamic5 {
    public static void main(String[] args) {
        int[] money = {1, 3, 2};
        int aim = 40;
        System.out.println("find all = " + find(money, aim));
        System.out.println("stupidFind1 = " + stupidFind1());
        System.out.println("find min = " + findMin(money, aim));
    }

    /*
    n种硬币组合成aim,有几种组合方式，动态规划
     */
    static int find(int[] money, int aim){
        int[][] f = new int[money.length+1][aim+1];
        for (int i = 0; i <= aim; i++) {
            f[0][i] = 0;
        }
        //  aim容量为0，一种放法
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
    暴力枚举 aim = a*n1 + b*n2 + c*n3 ...
     */
    static int stupidFind1(){
        int result = 0;
        for (int i = 0; i <= 40; i++) {
            for (int j = 0; j <= 14; j++) {
                for (int k = 0; k <= 10; k++) {
                    if (i+3*j+4*k == 40){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    /*
    凑成aim的最少零钱数目
    f[i][j] = min{f[i-1][j], f[i][j-money[i]]+1}
     */
    static int findMin(int[] money, int aim){
        int[][] f = new int[money.length+1][aim+1];

        for (int i = 0; i < money.length ; i++) {
            for (int j = 0; j <= aim; j++) {
                if (i==0) {
                    f[i][j] = 0;
                }
                else if (j==0) {
                    f[i][j] = 1;
                }
                else f[i][j] = 0;
            }
        }
        for (int i = 1; i <= money.length; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j-money[i-1] >= 0){
                    f[i][j] = Math.min(f[i-1][j], f[i][j-money[i-1]]+1);
                }
                else f[i][j] = f[i-1][j];
            }
        }
        return f[money.length][aim];
    }
}











