package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-08-11 19:02
 */
public class GetUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0){
            int need = sc.nextInt();
            int hour = sc.nextInt();
            int minute = sc.nextInt();
            int arrive = hour*60+minute;
            System.out.print((arrive-need)/60);
            System.out.print(" ");
            System.out.print((arrive-need)%60);
        }else {
            int[] time = new int[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    if (j==0) {
                        time[i] += 60*sc.nextInt();
                    }else {
                        time[i] += sc.nextInt();
                    }
                }
            }
            Arrays.sort(time);
            // System.out.println(Arrays.toString(time));

            int need = sc.nextInt();
            int hour = sc.nextInt();
            int minute = sc.nextInt();
            int arrive = hour*60+minute;
            // System.out.println(arrive);
            if (arrive < time[0]){
                arrive = arrive + 24*60;
            }
            for (int i = time.length-1; i >= 0; i--) {
                if ((arrive-need)>=time[i]){
                    System.out.print(time[i]/60);
                    System.out.print(" ");
                    System.out.print(time[i]%60);
                    break;
                }
            }
        }

    }
}
