package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-17 22:05
 * 2 3 5 6 7 1
 * 1 3 6 7 8 9 1
 * 3 6 7 1
 */
public class LCS {
    public static void main(String[] args) {

    }

    static void find(int[] source, int[] target){
        int[][] dp = new int[source.length+1][target.length+1];
        for (int i = 0; i < source.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < target.length; i++) {
            dp[0][i] = 0;
        }
        /*
        if s[i]==t[i], dp[i][j] = dp[i-1][j-1]+1
        if s[i]!=t[i], dp[i][j] = max(dp[i-1][j], dp[i][j-1])
         */
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < source.length; j++) {
                if (target[i] == source[j]) {
                    dp[i+1][j+1] = dp[i][j]+1;
                }
                else {
                    dp[i+1][j+1] = dp[i][j+1] >= dp[i+1][j] ? dp[i][j+1] : dp[i+1][j];
                }
            }
        }

    }
}
