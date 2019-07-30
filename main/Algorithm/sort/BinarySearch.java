package Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Lucas
 * @date 2019-05-26 13:31
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 输入有序数组
        String[] s = reader.readLine().split(" ");
        int target = Integer.parseInt(reader.readLine());
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        int position = search(array, 0, array.length - 1, target);
        System.out.println(position);

    }
    static int search(int[] array, int left, int right, int target){
        if (left <= right){
            int mid = (left+right)/2;
            if(array[mid] > target){
                return search(array, left, mid - 1, target);
            }
            else if (array[mid] < target){
                return search(array, mid + 1, right, target);
            }
            else if (array[mid] == target){
                return mid;
            }
        }
        return -1;
    }
}
