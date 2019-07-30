package Algorithm.sort;

import java.io.IOException;
import java.util.Arrays;
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
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // 排序
    static void sort(int[] array, int left, int right){
        if (left < right){
            int mid = (left + right)/2;
            sort(array, left, mid);          // 对左半边排序
            sort(array, mid+1, right);  // 对右半边排序
            merge(array, left, mid, right);
        }
    }

    // 合并
    /*static void merge(int[] array, int left, int mid, int right){
        // 拆成两个数组
        int[] l = new int[mid-left+1];
        int[] r = new int[right-mid];
        for (int i = left; i <= mid; i++) {
            l[i-left] = array[i];
        }
        for (int i = mid+1; i <= right; i++) {
            r[i-mid-1] = array[i];
        }
        // 两个数组比较大小
        int i = 0;
        int j = 0;
        int n = left;
        while (i <= mid-left && j <= right-mid-1){
            if (l[i] <= r[j]) {
                array[n] = l[i];
                n++;
                i++;
            } else {
                array[n] = r[j];
                n++;
                j++;
            }
        }

        if (i <= mid-left){
            for (int k = i; k <= mid-left; k++) {
                array[n] = l[k];
                n++;
            }
        }
        if (j <= right-mid-1){
            for (int k = j; k <= right-mid-1; k++) {
                array[n] = r[k];
                n++;
            }
        }
    }*/

    static void merge(int[] array, int left, int mid, int right){
        if (left >= right){
            return;
        }
        int[] result = new int[right-left+1];
        int i = left;
        int j = mid+1;
        int n = 0;

        while (i<=mid&&j<=right){
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

        if (i<=mid){
            for (int k = i; k <=mid ; k++) {
                result[n] = array[k];
                n++;
            }
        }
        if (j<=right){
            for (int k = j; k <= right; k++) {
                result[n] = array[k];
                n++;
            }
        }

        for (int k = left; k <= right ; k++) {
            array[k] = result[k-left];
        }
    }
}
