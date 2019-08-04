package Algorithm.greed;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-08-02 15:06
 * 已知有一些孩子和一些糖果，每个孩子都有需求因子g，每个糖果有大小s。
 * 当某个糖果大小s>=某个孩子的需求因子g，代表该糖果可以满足该孩子
 * 每个孩子最多只能使用1个糖果满足，求使用这些糖果最多能满足多少孩子
 */
public class ShareCandy {
    public static void main(String[] args) {
        int[] g = {5,10,2,9,15,9};   // 孩子需求因子
        int[] s = {6,1,20,3,8,2,4,6};      // 糖果大小
        Arrays.sort(g);              // 2,5,9,9,10,15
        Arrays.sort(s);              // 1,3,6,8,20
        int child = 0;
        int candy = 0;
        while (candy < s.length && child<g.length){
            if (g[child]<=s[candy]){
                child++;
            }
            candy++;
        }
        System.out.println("最多可以满足：" + child + "个");
    }
}
