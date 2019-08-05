package Algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-08-04 14:18
 * N皇后，将N个皇后放在N*N的棋盘上，使之不能互相攻击
 * 使用二维数组表示空棋盘Mark[][], 0表示还能放置棋子, 1表示不能放置棋子
 * 设置方向数组 (x-1,y-1)  (x-1,y)  (x-1,y+1)
 *            (x,y-1)     (x,y)    (x,y+1)
 *            (x+1,y-1)  (x+1,y)   (x+1,y+1)
 * int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}   上下左右、左上、右上、左下、右下
 * int[] dy = {0, 0, -1, 1, -1, 1, -1, 1}
 * 按照方向数组的8个方向分别延伸N个距离，只要不超过边界，Mark[][] = 1
 */
public class N_Queens {
    public static void main(String[] args) {
        int n = 8;
        int[][] mark = new int[n][n];
        String[][] location = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                location[i][j] = "*";
            }
        }
        ArrayList<String[][]> result = new ArrayList<>();
        generate(0, n, mark, location, result);
        for (String[][] ss : result) {
            for (String[] s : ss) {
                System.out.println(Arrays.toString(s));
            }
            System.out.println("------------------------");
        }
        System.out.println("一共有" + result.size() + "种");
    }

    // 放置任意一个棋子后，更新棋盘可放位置
    static void putOne(int[][] mark, int x, int y){
        // 方向数组！！！
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        mark[x][y] = 1;
        int n = mark.length;
        // 更新棋盘的八个方向

        for (int i = 0; i < mark.length; i++) {    // 最多向外延伸mark.length个单位
            for (int j = 0; j < 8; j++) {
                int newX = x+i*dx[j];              // 更新坐标
                int newY = y+i*dy[j];

                if (newX>=0&&newY>=0&&newX<mark.length&&newY<mark.length){
                    mark[newX][newY] = 1;
                }
            }
        }
    }

    // k表示已在第k行放置了第k个皇后, n表示一共要放置n个皇后，mark表示棋盘，location表示单次成功放置的结果，result存储所有成功放置的结果
    static void generate(int k, int n, int[][] mark, String[][] location, ArrayList<String[][]> result){
        // k从0开始计算
        if (k==n){
            // 添加放置成功的结果
            result.add(location);
            return;
        }
        // 按顺序尝试放置皇后到第0列~第n-1列
        for (int i = 0; i < n; i++) {
            if (mark[k][i]==0){
                // 记录回溯前的棋盘mark状况, 保存副本，二维数组深拷贝不能直接clone，要循环拷贝一位数组，坑爹。。。
                int[][] copyMark = new int[n][n];
                for (int j = 0; j < n; j++) {
                    copyMark[j] = mark[j].clone();
                }

                // 记录回溯前的结果location状况，保存副本，二维数组深拷贝不能直接clone，要循环拷贝一位数组，坑爹。。。
                String[][] copyLocation = new String[n][n];
                for (int j = 0; j < n; j++) {
                    copyLocation[j] = location[j].clone();
                }
                // 放置皇后
                location[k][i] = "Q";
                // 更新棋盘
                putOne(mark, k, i);

                // 递归寻找下一行皇后的位置
                generate(k+1, n, mark, location, result);

                // 回溯后要做的事，让mark和location指向相应的副本
                mark = copyMark;
                location = copyLocation;
            }
        }
    }
}
