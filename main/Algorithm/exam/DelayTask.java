package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/9/20 20:22
 */
public class DelayTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> order = new ArrayList<>();   // 按照延迟从小到大排列
        for (int i = 0; i < n; i++) {
            long numbers = sc.nextLong();
            long delay = sc.nextLong();
            for (int j = 0; j < numbers; j++) {
                order.add(delay);
            }
        }
        Collections.sort(order);

        long max = 0;
        int i = 0;
        int j = order.size()-1;
        while (i<j){
            long delay1 = order.get(i);
            long delay2 = order.get(j);
            long cur = delay1 + delay2;
            max = Math.max(max, cur);
            i++;
            j--;
        }
        System.out.println(max);
    }
}
