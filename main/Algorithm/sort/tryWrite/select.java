package algorithm.sort.tryWrite;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-06-23 16:00
 */
public class select {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.valueOf(s[i]);
        }
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void selectSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min = array[i];    // 最小值
            int index = i;         // 最小值所在的位置
            for (int j = i; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = min;
        }
    }
}
