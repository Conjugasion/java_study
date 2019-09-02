package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-08-30 19:51
 */
public class Rabbit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n,area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        return 0;
    }
    private static boolean work(int n, int x, int y, int cost, int[][] area){
        if (x<0||x>=n||y<0||y>=n){
            return false;
        }
        if (x==n-1||x==n-2) return true;
        if(work(n,x+2, y, cost+area[x+1][y], area)||work(n,x, y+2, cost+area[x][y+1], area)){
            return true;
        }
        return false;
    }
}
