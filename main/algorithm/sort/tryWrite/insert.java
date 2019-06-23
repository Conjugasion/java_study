package algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-16 21:54
 */
public class insert {
    public static void main(String[] args) {
        int[] array = {2, 4, 5, 7, 12, 1, 19};
        //insertSort2(array);
        insertSort1(array);
        System.out.println(Arrays.toString(array));
    }

    // 正着写 n2
    static void insertSort1(int[] array){
        if (array.length == 1 || array == null){
            return;
        }
        else {
            for (int i = 1; i < array.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (array[j] > array[i]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    // 反着写 n~n2
    static void insertSort2(int[] array){
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
