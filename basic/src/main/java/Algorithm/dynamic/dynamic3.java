package Algorithm.dynamic;


/**
 * @author Lucas
 * @date 2019-06-09 14:54
 * 0/1背包问题
 * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
 */
public class dynamic3 {
    public static void main(String[] args) {
        int[] w = {11,4,5,6,2,2,2,1};  //物品的重量
        int[] v = {100,6,4,5,3,6,1,5};  //物品的价值
        int m = 10;

        System.out.println(put(m, w.length-1, w, v));
    }

    /*
    递归版
    n件物品中选取若干件物品放入剩余空间为m的背包
     */
    static int put(int m, int n, int[] w, int[] v){
        if (m <=0 || n < 0){
            return 0;
        }
        if (m < w[n]){
            return put(m, n-1, w, v);
        }
        else {
            return Math.max(put(m, n-1, w, v), put(m-w[n], n-1, w, v)+v[n]);
        }
    }
}
