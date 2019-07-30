package Algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/7/26 11:18
 * 马走日，n*n棋盘找一条没有走过的路
 */
public class ZouXiangQi {
    public static void main(String[] args) {
        // 8*8的棋盘
        int n =8;
        int[] chessboard = new int[n*n];         // 初始化棋盘
        int[] hasPass = new int[n*n];            // 标记是否曾经经过，曾经经过为1，未曾经过为0
        int k = 0;
        ArrayList<int[]> result = new ArrayList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (findPath(chessboard, i, j, n, n, hasPass, k, result)){
                    found = true;
                    break;
                }
            }
        }
        System.out.println(found);
        for (int[] i:result) {
            System.out.println(Arrays.toString(i));
        }
    }

    // rows=8 cols=8
    static boolean findPath(int[] chessboard, int x, int y, int rows, int cols, int[] hasPass, int k, ArrayList<int[]> result){
        int index = x*cols+y;
        if (x<0||y<0||x>=rows||y>=cols||hasPass[index]==1) return false;
        // 别忘了加最后一次！
        if (k==chessboard.length-1) {
            result.add(new int[]{x,y});
            return true;
        }
        hasPass[index] = 1;
        int[] possible = new int[]{x,y};
        result.add(possible);
        if (findPath(chessboard, x-1, y+2, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x-1, y-2, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x+1, y+2, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x+1, y-2, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x-2, y+1, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x-2, y-1, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x+2, y+1, rows, cols, hasPass, k+1, result)||
            findPath(chessboard, x+2, y-1, rows, cols, hasPass, k+1, result)
        ){
            return true;
        }
        result.remove(possible);
        hasPass[index] = 0;
        return false;
    }
}
