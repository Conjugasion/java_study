package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.time.format.SignStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-05-26 12:17
 * 合并排序
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.valueOf(s[i]);
        }
        int[] result = new int[array.length];
        sort(array, 0, array.length-1, result);
        System.out.println(Arrays.toString(result));
    }

    // 排序
    static void sort(int[] array, int left, int right, int[] result){
        if (left < right) {
            int mid = (left + right) / 2;
            sort(array, left, mid, result);    //左边有序
            sort(array, mid + 1, right, result); //右边有序
            merge(array, left, right, result); //再将二个有序数列合并
        }
    }

    // 合并
    static void merge(int[] array, int left, int right, int[] result){
        if (left < right) return;

        int i = left;
        int mid = (left+right)/2;
        int j = mid + 1;
        int n = 0;

        while (i <= mid && j <= right){
            if (array[i] <= array[j]){
                result[n] = array[i];
                n++;
                i++;
            }
            else {
                result[n] = array[j];
                n++;
                j++;
            }
        }
        if (i <= mid){
            for (int k = i; k <= mid ; k++) {
                result[n] = array[i];
                n++;
            }
        }
        if (j <= right){
            for (int k = j; k <= right ; k++) {
                result[n] = array[j];
                n++;
            }
        }
    }
}
