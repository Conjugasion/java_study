package Algorithm.offer;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-08-31 16:17]
 * 顺时针打印矩阵
 * 1  2  3  4
 * 12 13 14 5
 * 11 16 15 6
 * 10 9  8  7
 */
public class ClockwisePrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
        int[][] mark = new int[matrix.length][matrix[0].length];

        ArrayList<Integer> result = printMatrix(matrix, mark);
        System.out.println(result);

    }
    static ArrayList<Integer> printMatrix(int[][] matrix, int[][] mark){
        ArrayList<Integer> result = new ArrayList<>();
        int x = 0;
        int y = 0;
        result.add(matrix[x][y]);
        mark[x][y] = 1;    // 标记为已经到达
        final int right = 1;
        final int down = 2;
        final int left = 3;
        final int up = 4;
        int state = right;
        while (result.size()<mark.length*mark[0].length){
            switch (state) {
                case right:
                    if (y+1<mark[0].length&&mark[x][y+1]==0){    // 没有越界并且未曾到达
                        y = y+1;
                        mark[x][y] = 1;
                        result.add(matrix[x][y]);
                    }else {
                        state = down;
                    }
                    break;
                case down:
                    if (x+1<mark.length&&mark[x+1][y]==0){
                        x = x+1;
                        mark[x][y] = 1;
                        result.add(matrix[x][y]);
                    }else {
                        state = left;
                    }
                    break;
                case left:
                    if (y-1>=0&&mark[x][y-1]==0){
                        y = y-1;
                        mark[x][y] = 1;
                        result.add(matrix[x][y]);
                    }else {
                        state = up;
                    }
                    break;
                case up:
                    if (x-1>=0&&mark[x-1][y]==0){
                        x = x-1;
                        mark[x][y] = 1;
                        result.add(matrix[x][y]);
                    }else {
                        state = right;
                    }
                    break;
            }
        }
        return result;
    }
}
