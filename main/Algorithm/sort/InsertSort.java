package Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-25 14:21
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        /*
        1 5 6 4 0
         */
        /*for (int i = 1; i < s.length; i++) {
            // 当前数比前一个大，并且大于等于索引为零的数
            if (array[i] < array[i-1] && array[i] >= array[0]){
                // 找到第一个比当前数小的数的位置
                for (int j = i-1; j >= 0; j--) {
                    if (array[j] <= array[i]){
                        // 移动数组
                        int temp = array[i];
                        for (int k = i; k > j+1; k--) {
                            array[k] = array[k-1];
                        }
                        array[j+1] = temp;
                        // 跳出循环
                        break;
                    }
                }
            }
            else if(array[i] < array[0]){
                int temp = array[i];
                for (int k = i; k > 0; k--) {
                    array[k] = array[k-1];
                }
                array[0] = temp;
            }
        }*/
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int i = 1; i < s.length; i++) {
            for (int j = i-1; j >=0; j--) {
                if (array[j+1] < array[j]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
                else break;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
