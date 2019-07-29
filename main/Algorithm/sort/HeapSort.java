package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-25 15:48
 * 堆排序
 */
public class HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        /*
        采用最小堆 2 4 1 5 3 6 [0,1,2,3,4]
         */
        // 建堆，然后再排序
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            heap(array);
            result[i] = array[0];
            array = Arrays.copyOfRange(array,1, array.length);
        }
        System.out.println(Arrays.toString(result));

    }
    static void heap(int[] array){
        while (true){
            boolean flag = true;
            for (int i = 0; i < array.length; i++) {
                int min;
                if (2*i+2 < array.length){
                    min = (array[2*i+1] < array[2*i+2]) ? 2*i+1:2*i+2;
                    if (array[i] > array[min]){
                        int temp = array[i];
                        array[i] = array[min];
                        array[min] = temp;
                        flag = false;
                    }
                }
                else if(2*i+1 < array.length){
                    if (array[i] > array[2*i+1]){
                        int temp = array[i];
                        array[i] = array[2*i+1];
                        array[2*i+1] = temp;
                        flag = false;
                    }
                }
            }
            if (flag) break;
        }
    }
}
