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
        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        /*ArrayList<Integer> allPath = new ArrayList<>();
        find(dungeon, dungeon.length, dungeon.length, 0, 0, 0, allPath);
        Collections.sort(allPath);
        System.out.println("回溯法de最少初始血量：" + allPath.get(0));*/
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
    // initSelf[i][j] 表示第i行第j列的数字变成1的代价
    // min = min{dp[i+1][j], dp[i][j+1]}
    // initSelf[i][j] = 1- dungeon[i][j]
    //


    static int find(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                dp[i][j] = -1;
            }
        }

        // 辅助数组
        int[][] initSelf = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] <= 0){
                    initSelf[i][j] = 1- matrix[i][j];
                }else {
                    initSelf[i][j] = 0;
                }
            }
        }

        if (initSelf[matrix.length-1][matrix.length-1] == 0){
            dp[matrix.length-1][matrix.length-1] = 0;
        }
        return 1;
    }
}
