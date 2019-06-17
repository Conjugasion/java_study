package algorithm.sort;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-16 21:54
 */
public class insert {
    public static void main(String[] args) {
        int[] array = {89, 6, 67, 12, 1, 21, 34};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (array[j+1] < array[j]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                else break;
            }
        }
    }
}
