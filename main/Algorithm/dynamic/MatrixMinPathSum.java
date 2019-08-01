package Algorithm.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Lucas
 * @date 2019/7/30 22:25
 * 已知一个二维数组，其中存储了非负整数，找到从左上角到右下角的一条路径，使得路径之和最小，只能向下或者向右移动
 * 1 3 1
 * 1 5 4
 * 4 2 1
 */
public class MatrixMinPathSum {
    public static void main(String[] args) {
        // int[][] matrix = new int[][]{{1,3,1},{1,5,4},{4,2,1}};
        Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            int dimension = random.nextInt(10)+1;// [1,10]的随机数
            int[][] matrix = new int[dimension][dimension];
            for (int j = 0; j < dimension; j++) {
                for (int k = 0; k < dimension; k++) {
                    matrix[j][k] = random.nextInt(10)+1;
                }
            }
            // 方法一
            ArrayList<Integer> allPathLength = new ArrayList<>();
            find(matrix, dimension, dimension, 0,0,0,allPathLength);
            Collections.sort(allPathLength);    // [9, 10, 9, 12, 11, 7]
            System.out.println("回溯法de最短路径为" + allPathLength.get(0));
            // 方法二
            System.out.println("动态规划de最短路径为" + smartFind(matrix));
            System.out.println("---------------------");
        }

    }

    // 回溯法，枚举法
    static boolean find(int[][] matrix, int rows, int cols, int x, int y, int pathLength, ArrayList<Integer> allPathLength){
        if (x>=rows||y>=cols||x<0||y<0) return false;
        if (x==rows-1&&y==cols-1) {
            pathLength += matrix[rows-1][cols-1];
            allPathLength.add(pathLength);
        }
        if (find(matrix,rows,cols,x+1,y,pathLength+matrix[x][y],allPathLength)||
            find(matrix,rows,cols,x,y+1,pathLength+matrix[x][y],allPathLength)
        ){
            return true;
        }
        //pathLength -= matrix[x][y];
        return false;
    }

    // 动态规划法
    // dp[i][j] 表示从第i行第j列到右下角的最短路径
    // dp[i][j] = min(dp[i+1][j], dp[i][j+1]) + dp[i][j]
    static int smartFind(int[][] matrix){
        int length = matrix.length;
        int[][] dp = new int[length][length];
        for (int i = length-1; i >= 0; i--) {
            for (int j = length-1; j >= 0; j--) {
                if (i==length-1&&j!=length-1){
                    dp[i][j] = dp[i][j+1] + matrix[i][j];
                }else if (j==length-1&&i!=length-1){
                    dp[i][j] = dp[i+1][j] + matrix[i][j];
                }else if (i==length-1&&j==length-1){
                    dp[length-1][length-1] = matrix[length-1][length-1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + matrix[i][j];
                }

            }
        }
        return dp[0][0];
    }
}
