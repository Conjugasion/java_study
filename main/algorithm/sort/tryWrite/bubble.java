package algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 16:13
 */
public class bubble {
    public static void main(String[] args) {
        int[] array = {8, 4, 3, 7, 12, 1, 19, 13};
        bubbleSort1(array);
        System.out.println(Arrays.toString(array));
    }

    static void bubbleSort1(int[] array){
        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    static void bubbleSort2(int[] array){
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
