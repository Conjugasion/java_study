package Algorithm.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/17 15:33
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，
 * 在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 *
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
 * 接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
 *
 * 输出描述:
 * 输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。
 *
 * 输入例子1:
 * 5
 * 2 3 3 3
 *
 * 输出例子1:
 * 9
 */
public class Song {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();
        int B = sc.nextInt();
        int Y = sc.nextInt();
        int[] songs = new int[X+Y];
        for (int i = 0; i < songs.length; i++) {
            if (i<X){
                songs[i] = A;
            }else songs[i] = B;
        }
        find(songs, k);
    }

    // 动态规划
    // dp[i][j] 表示 只使用1~i个数字填充j空间有几种方法
    // dp[i][j] = dp[i-1][j] + dp[i-1][j-songs[i]], if j>=songs[i];
    //          = dp[i-1][j], if j<songs[i];
    static void find(int[] songs, int k){
        long[][] dp = new long[songs.length+1][k+1];
        for (int i = 0; i <= songs.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= songs.length; j++) {
                if (i>=songs[j-1]){
                    dp[j][i] = dp[j-1][i]%1000000007 + dp[j-1][i-songs[j-1]]%1000000007;
                }else dp[j][i] = dp[j-1][i]%1000000007;
            }
        }
        System.out.println(dp[songs.length][k]%1000000007);
    }
}
