package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/25 15:27
 */
public class ABword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();

        /*long[] bigs = new long[50];
        int i = 0;
        for (; i < bigs.length; i++) {
            bigs[i] = (long)Math.pow(2, i+2) - 2;
            if (k<=bigs[i]) break;
        }
        // 排列中第几个
        long sub = bigs[i];
        // 位数
        i = i+1;
        long maxValue = (long)Math.pow(2, i)-1;
        long cur = maxValue - (sub- k);
        String s = Long.toBinaryString(cur);
        int length = s.length();
        for (long j = 0; j < i-length; j++) {
            s = "0" + s;
        }
        //System.out.println("s = " + s);
        String replace = s.replace('1', 'b').replace('0', 'a');
        System.out.println(replace);*/

        int[] array = new int[n+m];
        for (int i = 0; i < n; i++) {
            array[i] = 0;
        }
        for (int i = n; i < n+m; i++) {
            array[i] = 1;
        }

    }

    static void pailie(int[] array, int from, int to, ArrayList<String> result){
        if (from == to) {
            String s = "";
            for (int i = 0; i <= to; i++) {
                if (array[i]==0){
                    s = s+"a";
                }else s = s+"b";
            }
            result.add(s);
        }
        for (int i = from; i <= to; i++) {
            boolean isSwap = true;
            for (int j = from; j < i; j++) {
                if (array[j] == array[i]){
                    isSwap = false;               // 置true 可重复排列
                }
            }
            if (isSwap){
                int s1 = array[i];
                array[i] = array[from];
                array[from] = s1;
                pailie(array, from+1, to, result);
                int s2 = array[i];
                array[i] = array[from];
                array[from] = s2;
            }
        }
    }
}
