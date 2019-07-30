package Algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 20:20
 */
public class Heap {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 13, 7, 12, 1, 19};
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            buildHeap(array);
            result[i] = array[0];
            array = Arrays.copyOfRange(array, 1, array.length);
        }
        System.out.println(Arrays.toString(result));
    }

    // 采用最小堆 2 4 1 5 3 6 [0,1,2,3,4,5]
    static void buildHeap(int[] array){
        while (true){
            boolean flag = true;
            for (int i = 0; i < array.length; i++) {
                if (2*i+2 < array.length){
                    int min = array[2*i+2] < array[2*i+1] ? 2*i+2 : 2*i+1;
                    if (array[min] < array[i]){
                        int temp = array[min];
                        array[min] = array[i];
                        array[i] = temp;
                        flag = false;
                    }
                }
                else if (2*i+1 < array.length){
                    if (array[2*i+1] < array[i]){
                        int temp = array[2*i+1];
                        array[2*i+1] = array[i];
                        array[i] = temp;
                        flag = false;
                    }
                }
            }
            if (flag) break;
        }
    }
}
