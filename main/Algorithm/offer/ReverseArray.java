package Algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/8/6 16:59
 * 反转数组
 * 双指针，一个从头到尾，一个从尾到头，直到两者相遇
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {1,2,3,4,5,6};
        reverse(array1);
        reverse(array2);
        System.out.println("array1: " + Arrays.toString(array1));
        System.out.println("array2: " + Arrays.toString(array2));
    }

    static void reverse(int[] array){
        for (int i = 0, j = array.length-1; i <= j; i++,j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
