package algorithm;

/**
 * @author Lucas
 * @date 2019-06-09 14:54
 * 完全背包问题
 * f[i][v]=max{f[i-1][v-k*c[i]]+k*w[i]|0<=k*c[i]<=v}
 */
public class dynamic4 {
    public static void main(String[] args) {
        int[] w = {1,4,5,6,2,2,2,1};  //物品的重量
        int[] v = {5,6,4,5,3,6,1,5};  //物品的价值
        int m = 10;
        int[][] F = new int[w.length+1][m+1];
        System.out.println(put(m, w.length,w,v,F));

    }

    /*
    n件物品中选取若干件物品放入剩余空间为m的背包
     */
    static int put(int m, int n, int[] w, int[] v, int[][] F){
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= j/w[i-1]; k++) {
                    F[i][j] = F[i-1][j-k*w[i-1]]+k*v[i-1] > F[i][j] ? F[i-1][j-k*w[i-1]]+k*v[i-1] : F[i][j];
                }
            }
        }
        return F[n][m];
    }
}
