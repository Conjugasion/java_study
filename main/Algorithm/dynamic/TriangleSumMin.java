package Algorithm.dynamic;

/**
 * @author Lucas
 * @date 2019/7/30 21:00
 * 给定一个二维数组，其保存了一个数字三角形，从顶端走到底端，每次可以向下走相邻的两个位置
 *     2
 *    3 4
 *   5 6 7
 * 8 9 10 11
 */
public class TriangleSumMin {
    public static void main(String[] args) {
        int[][] triangle = new int[][]{{2},{3,4},{5,6,7},{8,9,10,11}};
        System.out.println(pathMin(triangle));
    }

    // dp[i][j] 表示第i行第j列的点到底端的最短路径长度
    static int pathMin(int[][] triangle){
        int[][] dp = new int[triangle.length][];
        dp[triangle.length-1] = new int[triangle[triangle.length-1].length];
        for (int i = 0; i < triangle[triangle.length-1].length; i++) {
            dp[triangle.length-1][i] = triangle[triangle.length-1][i];
        }
        for (int i = triangle.length-2; i >= 0; i--) {
            dp[i] = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
