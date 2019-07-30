package Algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 19:17
 */
public class Merge {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 13, 7, 12, 1, 19};
        sort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // 排序
    static void sort(int[] array, int left, int right){
        if (left < right){
            int mid = (left+right)/2;
            sort(array, left, mid);
            sort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }


    // 合并两个数组
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
}
