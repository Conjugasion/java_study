package Algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Lucas
 * @date 2019/7/31 22:19
 * 已知一个存储整数的二维数组，左上角代表骑士位置，右下角代表公主位置。骑士只能向下、向右走
 * 正数可以给其实增加生命值，负数会减少骑士生命值。
 * 问骑士初始时至少是多少生命值，才可以保证骑士在行走的过程中至少保持生命值为1。
 * -2  -3   3
 * -5  -10  10   初始血量至少为7， 7-2-3+3+1-5 = 1
 * 10  30  -5
 */
public class DungeonGame {
    public static void main(String[] args) {
       // int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] dungeon = {{3},{2},{-6}};

        /*ArrayList<Integer> allPath = new ArrayList<>();
        find(dungeon, dungeon.length, dungeon.length, 0, 0, 0, allPath);
        Collections.sort(allPath);
        System.out.println("回溯法de最少初始血量：" + allPath.get(0));*/
        System.out.println("动态规划法de最少初始血量：" + find(dungeon));
    }

    // 回溯法，枚举法，不对
    static boolean find(int[][] matrix, int rows, int cols, int x, int y, int blood, ArrayList<Integer> allPath){
        if (x>=rows||y>=cols||x<0||y<0) return false;
        if (x==rows-1&&y==cols-1) {
            blood += matrix[x][y];
            allPath.add(blood);
            return true;
        }
        if (find(matrix, rows, cols, x+1, y, blood-matrix[x][y], allPath)||
            find(matrix, rows, cols, x, y+1, blood-matrix[x][y], allPath)
        ){
            return true;
        }
        return false;
    }

    // 动态规划
    // dp[i][j] 表示从第i行第j列能走到右下角的最少起始血量 [0,+]
    // 假如仅一个格子dungeon[0][0]，若dungeon[0][0]>0，dp[0][0]=1;
    //                           若dungeon[0][0]=0，dp[0][0]=1;
    //                           若dungeon[0][0]<0，dp[0][0]=1-dungeon[0][0];
    //                           即dp[0][0]=max{1，1-dungeon[0][0]}
    // min = min{dp[i+1][j], dp[i][j+1]}
    // if (Math.max(1, 1-matrix[i][j]) + matrix[i][j] >= min), dp[i][j] = Math.max(1, 1-matrix[i][j]);
    // if (Math.max(1, 1-matrix[i][j]) + matrix[i][j] < min), dp[i][j] = min - matrix[i][j]

    static int find(int[][] matrix){
        int xlength = matrix.length;
        int ylength = matrix[0].length;
        int[][] dp = new int[xlength][ylength];
        for (int i = 0; i < xlength; i++) {
            for (int j = 0; j < ylength; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = xlength-1; i >= 0; i--) {
            for (int j = ylength-1; j >= 0; j--) {
                if (i==xlength-1&&j!=ylength-1){
                    // 如果初始血量+当前格子的血量 >= 下一步要走位置的最低初始血量，则不需要额外增加血量
                    if (Math.max(1, 1-matrix[i][j]) + matrix[i][j] >= dp[i][j+1]) {
                        dp[i][j] = Math.max(1, 1-matrix[i][j]);
                    // 如果初始血量+当前格子的血量 < 下一步要走位置的最低初始血量，则需要额外增加血量
                    }else {
                        dp[i][j] = dp[i][j+1] - matrix[i][j];
                    }
                }else if (i!=xlength-1&&j==ylength-1){
                    if (Math.max(1, 1-matrix[i][j]) + matrix[i][j] >= dp[i+1][j]) {
                        dp[i][j] = Math.max(1, 1-matrix[i][j]);
                    }else {
                        dp[i][j] = dp[i+1][j] - matrix[i][j];
                    }
                }else if (i==xlength-1&&j==ylength-1){
                    dp[i][j] = Math.max(1, 1-matrix[i][j]);
                }else {
                    int min = Math.min(dp[i+1][j], dp[i][j+1]);
                    if (Math.max(1, 1-matrix[i][j]) + matrix[i][j] >= min) {
                        dp[i][j] = Math.max(1, 1-matrix[i][j]);
                    }else {
                        dp[i][j] = min - matrix[i][j];
                    }
                }
            }
        }
        return dp[0][0];
    }
}
