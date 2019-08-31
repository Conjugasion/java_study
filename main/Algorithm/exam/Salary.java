package Algorithm.exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-08-11 19:46
 */
public class Salary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();       // 员工数
        int[] year = new int[n];
        for (int i = 0; i < n; i++) {
            year[i] = sc.nextInt();
        }
        HashMap<Integer, Integer> money = new HashMap<>();
        money.put(0, 100);

        for (int i = 1; i < n; i++) {
            if (year[i]>year[i-1]){
                money.put(i, money.get(i-1)+100);
            }else if (year[i]<year[i-1]){
                money.put(i, money.get(i-1)-100);
            }else {
                money.put(i, money.get(i-1));
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i:money.keySet()) {
            min = min <= money.get(i) ? min : money.get(i);
            sum += money.get(i);
        }
        if (min <= 0){
            sum = sum + money.size()*(100-min);
        }
        System.out.print(sum);
    }
}
