package algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-21 19:36
 */
public class MultiMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][m];
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        /*int[][] newM = newMatrix(matrix, 2, 2, 3, 3);
        System.out.println(Arrays.toString(newM[0]));
        System.out.println(Arrays.toString(newM[1]));
        System.out.println(Arrays.toString(maxIndex(newM)));*/

        if(n==1&&m==1){
            System.out.println(matrix[0][0]);
        }
        else if(n==1){
            Arrays.sort(matrix[0]);
            System.out.println(matrix[0][m-1]);
        }else if(m==1){
            int max = matrix[0][0];
            for (int i = 0; i < n; i++) {
                if (max<matrix[i][0]){
                    max = matrix[i][0];
                }
            }
            System.out.println(max);
        }else {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int[][] newM = newMatrix(matrix,i,j,n,m);
                int[] index = maxIndex(newM);
                int maxNum = newM[index[0]][index[1]];
                int sum = maxNum*matrix[i][j];
                if (sum>max){
                    max = sum;
                }
            }
        }
        System.out.println(max);
        }
    }

    static int[][] newMatrix(int[][] matrix, int column, int row, int n, int m){
        int[][] newM = new int[n-1][m-1];
        int x = 0;
        for (int i = 0; i < n; i++) {
            int y = 0;
            if (i==column) continue;
            for (int j = 0; j < m; j++) {
                if (j==row) continue;
                newM[x][y] = matrix[i][j];
                y++;
            }
            x++;
        }
        return newM;
    }

    // 找到最大值的索引
    static int[] maxIndex(int[][] array){
        int[] xy = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[xy[0]][xy[1]] < array[i][j]){
                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }
        return xy;
    }
}
