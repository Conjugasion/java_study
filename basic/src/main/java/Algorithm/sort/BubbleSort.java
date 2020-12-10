package Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-25 11:39
 * 冒泡排序
 */
public class BubbleSort {
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
        /*for (int k = 0; k < s.length - 1; k++) {
            for (int i = 0,j = i+1;  j <  s.length; i++, j++) {
                if (array[i]>array[j]){
                    int temp =  array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }*/

        for (int i = s.length-1; i>0; i--) {
            for (int j =0 ; j < i-1; j++) {
                if (array[j]>array[j+1]){
                    int temp =  array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
