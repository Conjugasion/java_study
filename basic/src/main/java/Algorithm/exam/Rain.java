package Algorithm.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2020/3/20 19:54
 */
public class Rain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s1 = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(s1[j]);
            }
        }
        System.out.println(rain(matrix));

    }
    static class Backet{
        int row;
        int col;
        int height;

        Backet(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    static int rain(int[][] matrix){
        PriorityQueue<Backet> q = new PriorityQueue<>(Comparator.comparingInt((Backet backet)->backet.height));
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            hasVisited[i][0] = hasVisited[i][n-1] = true;
            q.add(new Backet(i,0,matrix[i][0]));
            q.add(new Backet(i,n-1,matrix[i][n-1]));
        }
        for (int i = 0; i < n-1; i++) {
            hasVisited[0][i] = hasVisited[m-1][i] = true;
            q.add(new Backet(0,i,matrix[0][i]));
            q.add(new Backet(m-1,i,matrix[m-1][i]));
        }
        int result = 0;
        int[][] ways = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            Backet now = q.poll();
            for (int[] way:ways) {
                int row = now.row+way[0];
                int col = now.col+way[1];
                if(row>=0&&row<m&&col>=0&&col<n&&!hasVisited[row][col]){
                    result+=Math.max(0,now.height-matrix[row][col]);
                    hasVisited[row][col] = true;
                    q.add(new Backet(row,col,Math.max(matrix[row][col],now.height)));
                }
            }
        }
        return result;
    }
}
