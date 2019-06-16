package algorithm.dynamic;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-06-08 16:01
 * 在上面的数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可
 */
public class dynamic1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        s.nextLine();
        int[][] triangle = new int[row][];
        for (int i = 0; i < row; i++) {
            String[] str = s.nextLine().split(" ");
            triangle[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.valueOf(str[j]);
            }
        }

        System.out.println(MaxSum1(triangle, 0, 0));


        int[][] midResult = new int[row][];
        for (int i = 0; i < row; i++) {
            midResult[i] = new int[i+1];
            for (int j = 0; j < i+1; j++) {
                midResult[i][j] = -1;
            }
        }
        System.out.println(MaxSum2(triangle, midResult, 0, 0));

        System.out.println(MaxSum3(triangle, midResult, 0, 0));

    }

    /*
    纯递归
     */
    static int MaxSum1(int[][] triangle, int i, int j){
        if (i == triangle.length - 1){
            return triangle[i][j];
        }
        else {
            int option1 = MaxSum1(triangle, i+1, j);
            int option2 = MaxSum1(triangle, i+1, j+1);
            return Math.max(option1, option2) + triangle[i][j];
        }
    }
    /*
    保存中间过程的递归 记忆递归型
     */
    static int MaxSum2(int[][] triangle, int[][] midResult, int i, int j){
        if (midResult[i][j] != -1){
            return midResult[i][j];
        }
        if (i == triangle.length - 1){
            midResult[i][j] = triangle[i][j];
        }
        else {
            int option1 = MaxSum2(triangle, midResult, i+1, j);
            int option2 = MaxSum2(triangle, midResult, i+1, j+1);
            midResult[i][j] = Math.max(option1, option2) + triangle[i][j];
        }
        return midResult[i][j];
    }
    /*
    递推
     */
    static int MaxSum3(int[][] triangle, int[][] midResult, int i, int j){
        for (int m = 0; m < triangle[triangle.length - 1].length; m++) {
            midResult[triangle.length - 1][m] = triangle[triangle.length - 1][m];
        }
        for (int k = triangle.length - 2; k >= 0; k--) {
            for (int l = 0; l < k+1; l++) {
                midResult[k][l] = Math.max(midResult[k+1][l], midResult[k+1][l+1]) + triangle[k][l];
            }
        }
        return midResult[i][j];
    }




}
