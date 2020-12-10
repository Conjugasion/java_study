package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 20:14
 */
public class Customer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] person = new int[n];
        for (int i = 1; i <= n; i++) {
            map.put(i, new int[]{sc.nextInt(), sc.nextInt()});    // ai, bi
            person[i-1] = i;
        }
        ArrayList<int[]> result = new ArrayList<>();
        pailie(person, 0, n-1, result);
        System.out.println(min(result, map, n));
    }

    static int min(ArrayList<int[]> result, HashMap<Integer, int[]> map, int n){
        int min = Integer.MAX_VALUE;
        for (int[] arr:result) {
            int value = 0;
            for (int i = 0; i < arr.length; i++) {
                int[] ab = map.get(arr[i]);
                int a = ab[0];
                int b = ab[1];
                value += a*i+b*(n-i-1);
            }
            min = min <= value ? min : value;
        }
        return min;
    }

    static void pailie(int[] array, int from, int to, ArrayList<int[]> result){
        if (from == to) {
            int[] num = new int[to+1];
            for (int i = 0; i <= to; i++) {
                num[i] = array[i];
            }
            result.add(num);
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
