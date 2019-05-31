package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-25 13:39
 * 选择排序
 */
public class SelectSort1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        /*
        2 4 3 5
         */
        for (int i = 0; i < s.length; i++) {
            int min = i;
            for (int j = i; j < s.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
