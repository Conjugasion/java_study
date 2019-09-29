package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/25 15:17
 */
public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 植树点
        int m = sc.nextInt();   // 人数
        int[] mark = new int[n];
        int[] count = new int[]{0};
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            seed(left, right, mark, result, count);
        }
        for (int i:result) {
            System.out.println(i);
        }
    }

    static void seed(int left, int right, int[] mark, ArrayList<Integer> result, int[] count){
        for (int i = left; i <= right; i++) {
            if (mark[i-1] == 0){
                count[0]++;
                mark[i-1] = 1;
            }
        }
        result.add(count[0]);
    }
}
