package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 12:17
 * 合并排序
 */
public class MergeSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int[] array = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }
        List<Integer> result = new ArrayList<>(s.length);
        merge(array, 0, s.length-1, result);
        System.out.println(result);

    }
    static void merge(int[] array, int left, int right, List<Integer> result){
        if (left >= right){
            return;
        }
        int i = left;
        int mid = (left + right)/2;
        int j = mid + 1;


        while (i < mid + 1 && j <= right){
            if (array[i] < array[j]){
                result.add(array[i]);
            }else result.add(array[j]);
            i++;
            j++;
        }

        if (i < mid + 1){
            for (int k = i; k < mid + 1; k++) {
                result.add(array[i]);
            }
        }
        if (j < right){
            for (int k = j; k <= right; k++) {
                result.add(array[j]);
            }
        }
        merge(array, i, mid, result);
        merge(array, mid+1, j, result);
    }
}
