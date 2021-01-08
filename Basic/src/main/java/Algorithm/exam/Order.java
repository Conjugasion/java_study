package Algorithm.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 15:02
 */
public class Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(",");
        String[] ss = s[s.length - 1].split(";");
        int n = Integer.valueOf(ss[1]);

        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();

        for (int i = 0; i < s.length-1; i++) {
            int num = Integer.valueOf(s[i]);
            if (num%2==0){
                even.add(num);
            }else {
                odd.add(num);
            }
        }
        int last = Integer.valueOf(ss[0]);
        if (last%2==0) even.add(last);
        else odd.add(last);

        even.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        odd.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        ArrayList<Integer> nums = new ArrayList<>();
        nums.addAll(even);
        nums.addAll(odd);
        for (int i = 0; i < n-1; i++) {
            System.out.print(nums.get(i) + ",");
        }
        System.out.print(nums.get(n-1));
    }
}
