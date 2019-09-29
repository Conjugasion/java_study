package Algorithm.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/25 15:02
 */
public class MinMulti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (!arr.contains(num)) arr.add(num);
        }
        Collections.sort(arr);
        if (m==0) System.out.println(0);
        else if (m==1) {
            System.out.println(arr.get(0)*arr.get(1));
        }else {
            int sum = 0;
            int i = 0;int j = 2*m-1;
            while(i<j){
                sum += arr.get(i)*arr.get(j);
                i++;j--;
            }
            System.out.println(sum);
        }
    }
}
