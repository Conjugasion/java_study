package Algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 19:17
 */
public class Merge {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 13, 7, 12, 1, 19};
        sortExercise1(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // 排序
    static void sort(int[] array, int left, int right){
        if (left < right){
            int mid = (left+right)/2;
            // 对左边进行排序
            sort(array, left, mid);
            // 对右边进行排序
            sort(array, mid+1, right);
            // 将左、右的有序数组进行合并
            merge(array, left, mid, right);
        }
    }


    // 合并两个有序数组
    static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right-left+1];
        int n = 0;
        int i = left;
        int j = mid+1;

        while (i <= mid && j <= right){
            if (array[i] <= array[j]){
                temp[n] = array[i];
                n++;
                i++;
            }
            else {
                temp[n] = array[j];
                n++;
                j++;
            }
        }

        if (i <= mid){
            for (int k = i; k <= mid; k++) {
                temp[n] = array[k];
                n++;
            }
        }
        if (j <= right){
            for (int k = j; k <= right; k++) {
                temp[n] = array[k];
                n++;
            }
        }
        for (int k = 0; k < temp.length; k++) {
            array[k+left] = temp[k];
        }
    }

    // 排序练习
    static void sortExercise1(int[] array, int start, int end){
        if (start < end){
            int mid = (start+end)/2;
            sortExercise1(array, start, mid);
            sortExercise1(array, mid+1, end);
            mergeExercise1(array, start, mid, end);
        }
    }

    // 合并练习
    static void mergeExercise1(int[] array, int start, int mid, int end){
        if (start < end){
            int i = start;
            int j = mid+1;
            int[] temp = new int[end-start+1];
            int n = 0;

            while (i<=mid && j<=end){
                if (array[i]<=array[j]){
                    temp[n] = array[i];
                    n++;i++;
                }else {
                    temp[n] = array[j];
                    n++;j++;
                }
            }

            if (i<=mid){
                for (int k = i; k <= mid; k++) {
                    temp[n] = array[k];
                    n++;
                }
            }
            if (j<=end){
                for (int k = j; k <= end; k++) {
                    temp[n] = array[k];
                    n++;
                }
            }

            for (int k = start; k <= end; k++) {
                array[k] = temp[k-start];
            }
        }
    }
}
