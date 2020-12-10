package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/20 21:39
 */
public class YiHuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a1.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            a2.add(sc.nextInt());
        }
        ArrayList<Integer> a3 = new ArrayList<>();
        for (int x:a1) {
            for (int y:a2) {
                int sum = x+y;
                if (a3.contains(sum)){
                    a3.remove((Integer) sum);
                }else a3.add(sum);
            }
        }

        int first = a3.get(0);
        for (int i = 1; i < a3.size(); i++) {
            first = first^a3.get(i);
        }
        System.out.println(first);
    }
}
