package Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-28 17:27
 */
public class OJInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        System.out.println(Arrays.toString(str));
    }
}
