package Algorithm.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/20 19:27
 */
public class ReverseStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Arrays.asList(s).sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
        for (int i = 0; i < s.length-1; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.print(s[s.length-1]);
    }
}
