package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-08-11 19:30
 */
public class Secret {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();    // n位
        int k = sc.nextInt();    // 被写下k次
        sc.nextLine();
        String str = sc.nextLine();    // n+k-1位的str

        char[] chars = str.toCharArray();  // n+k-1位
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = (int)chars[i]-48;
        }
        // System.out.println(Arrays.toString(ints));
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            result.add(new int[n+k-1]);
        }

        int[] temp = new int[n+k-1];
        for (int i = 0; i < ints.length; i++) {
            temp[i] = ints[i];
            for (int j = 0; j < k-1; j++) {
                temp[i] =  temp[i] ^ result.get(j)[i];
            }
            for (int j = 0; j < k-1; j++) {
                if (i+j+1<n+k-1){
                    result.get(j)[i+j+1] = temp[i];
                }
            }
        }
        System.out.print(Arrays.toString(Arrays.copyOfRange(temp, 0, n)));

    }

}
