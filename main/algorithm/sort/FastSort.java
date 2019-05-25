package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-25 17:11
 * 快速排序
 */
public class FastSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);

        }
        location(array, 0, s.length-1);
        System.out.println(Arrays.toString(array));


    }
    // 以最左边的元素为轴枢
    static void location(int[] array, int left, int right){
        if (left >= right){
            return ;
        }
        int i = right;
        int j = left;
        int pivot = array[left];
        while (i != j){
            while (array[i] >= pivot && i > j) {
                i--;
            }
            while (array[j] <= pivot && i > j){
                j++;
            }
            if (i > j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = pivot;

        location(array, left, i-1);
        location(array, i+1, right);
    }
}








