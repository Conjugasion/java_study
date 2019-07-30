package Algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-17 22:05
 * 2 3 5 6 7 1
 * 1 3 6 7 8 9 1
 * 3 6 7 1
 */
public class LCS {
    public static void main(String[] args) {
        int[] source = {2, 3, 5, 4, 8, 10, 6, 7};
        int[] target = {2, 3, 7, 5, 9, 1, 10, 4, 8, 6};
        System.out.println("最长公共子序列：" + Arrays.toString(find(source, target)));
        String str1 = "belong";
        String str2 = "cnblongs";
        System.out.println("最长公共字串：" + find(str1,str2));
    }

    //最长公共子序列  不必要连续
    static int[] find(int[] source, int[] target){
        int[][] dp = new int[source.length+1][target.length+1];
        /*
        if s[i]==t[i], dp[i][j] = dp[i-1][j-1]+1
        if s[i]!=t[i], dp[i][j] = max(dp[i-1][j], dp[i][j-1])
         */
        for (int i = 0; i <= source.length; i++) {
            for (int j = 0; j <= target.length; j++) {
                if (i==0||j==0){
                    dp[i][j] = 0;
                }
                else if (source[i-1] == target[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;

                }
                else {
                    dp[i][j] = dp[i][j-1] >= dp[i-1][j] ? dp[i][j-1] : dp[i-1][j];
                }
            }
        }
        int num = dp[source.length][target.length];
        int i = source.length;
        int j = target.length;
        int[] result = new int[num];
        while (i!=0&&j!=0){
            if (source[i-1]==target[j-1]){
                result[num-1] = source[i-1];
                num--;
            }
            if (dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else {
                j--;
            }
        }
        return result;
    }

    //最长公共字串 必须连续
    static String find(String source, String target){
        int num = 0;
        int[][] dp = new int[source.length()+1][target.length()+1];
        ArrayList<int[]> possible = new ArrayList<>();
        for (int i = 0; i <= source.length(); i++) {
            for (int j = 0; j <= target.length(); j++) {
                if (i==0|j==0){
                    dp[i][j]=0;
                }
                else if (source.toCharArray()[i-1]==target.toCharArray()[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    if (num < dp[i][j]) {
                        num = dp[i][j];
                        possible.add(new int[]{i,j});
                    }
                }
                else dp[i][j]=0;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int[] i : possible) {
            if (dp[i[0]][i[1]]==num){
                for (int j = num; j > 0; j--) {
                    result.append(source.toCharArray()[i[0] - j]);
                }
            }
        }
        return result.toString();
    }
}
