package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 20:02
 */
public class BoxAndKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // box
        int m = sc.nextInt();   // key
        int boxEven = 0;
        int boxOdd = 0;
        int keyEven = 0;
        int keyOdd = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num%2==0) boxEven++;
            else boxOdd++;

        }
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if (num%2==0) keyEven++;
            else keyOdd++;
        }
        int poss1 = boxEven <= keyOdd ? boxEven : keyOdd;
        int poss2 = boxOdd <= keyEven ? boxOdd : keyEven;
        int poss = poss1 + poss2;
        System.out.println(poss);
    }
}
