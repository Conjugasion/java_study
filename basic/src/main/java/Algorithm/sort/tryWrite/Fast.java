package Algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 19:41
 */
public class Fast {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 13, 7, 12, 1, 19};
        fastExercise1(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }


    static void fastSort(int[] array, int left, int right){
        if (left < right){
            int pivot = array[left];
            int i = left;
            int j = right;

            while (i < j){
                //  右边哨兵先动！！！
                if (array[j] >= pivot){
                    j--;
                }
                else if (array[i] <= pivot){
                    i++;
                }
                else {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[j];
            array[j] = pivot;
            array[left] = temp;

            fastSort(array, left, j-1);
            fastSort(array, j+1, right);
        }
    }

    // 练习
    static void fastExercise1(int[] array, int start, int end){
        if (start<end){
            int pivot = array[start];
            int i = start;
            int j = end;

            while (i<j){
                if (pivot<=array[j]){
                    j--;
                }else if (pivot>=array[i]){
                    i++;
                }else {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            array[start] = array[j];
            array[j] = pivot;

            fastExercise1(array, start, j-1);
            fastExercise1(array, j+1, end);
        }
    }
}
