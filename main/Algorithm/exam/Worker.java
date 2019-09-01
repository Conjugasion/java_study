package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 20:36
 */
public class Worker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boxes.add(sc.nextInt());
        }
        System.out.println(n+1);
    }
}
