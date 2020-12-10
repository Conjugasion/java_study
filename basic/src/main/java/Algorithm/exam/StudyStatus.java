package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 20:46
 */
public class StudyStatus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> status = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            status.add(sc.nextInt());
        }
        long max = Long.MIN_VALUE;
        for (int i = 0; i <= n-1; i++) {
            long value = findMax(status, i);
            max = max >= value ? max : value;
        }
        System.out.println(max);
    }

    // 以某天结尾的最高评分
    static long findMax(ArrayList<Integer> status, int index){
        long max = Long.MIN_VALUE;
        for (int i = 0; i<=index; i++) {
            long sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = index-i; j <= index; j++) {
                sum += status.get(j);
                min = min <= status.get(j) ? min : status.get(j);
            }
            /*System.out.println("和：" + sum);
            System.out.println("最小：" + min);
            System.out.println("-------------");*/
            long all = min*sum;
            max = max >= all ? max : all;
        }
        return max;
    }
}
