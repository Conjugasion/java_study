package Algorithm.sort.tryWrite;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-23 20:20
 */
public class Heap {
    public static void main(String[] args) {
        int[] array = {2, 4, 1, 5, 13, 7, 12, 1, 19};
        /*int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            buildHeap(array);
            result[i] = array[0];
            array = Arrays.copyOfRange(array, 1, array.length);
        }
        System.out.println(Arrays.toString(result));*/

        System.out.println(Arrays.toString(sortExercise1(array)));
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

    // 建立小顶堆，练习
    static void heapExercise1(int[] array){

        while (true){
            boolean flag = true;        // 查看该轮是否有变动
            for (int i = 0; i < array.length; i++) {
                if (2*i+2<array.length){
                    int min = array[2*i+1] < array[2*i+2] ? 2*i+1 : 2*i+2;
                    if (array[i] > array[min]){
                        int temp = array[i];
                        array[i] = array[min];
                        array[min] = temp;
                        flag = false;
                    }
                }else if (2*i+1<array.length){
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

    // 堆排练习
    static int[] sortExercise1(int[] array){
        int[] result = new int[array.length];
        for (int i = 0; i < result.length; i++) {
            buildHeap(array);
            result[i] = array[0];
            array = Arrays.copyOfRange(array, 1, array.length);
        }
        return result;
    }
}
