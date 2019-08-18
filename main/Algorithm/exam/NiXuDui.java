package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/17 20:24
 */
public class NiXuDui {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int length = (int)Math.pow(2, n);
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] qs = new int[m];
        for (int i = 0; i < m; i++) {
            qs[i] = sc.nextInt();
        }
        for (int q:qs) {
            swap(array, q);
            System.out.println(inversePairs(array));
        }


    }

    static void swap(int[] array, int q){
        if (q==0) return;
        int num = (int)Math.pow(2, q);
        for (int i = 0; i < (array.length/num); i++) {
            for (int j = i*num, k=i*num+num-1; j<k; j++,k--) {
                int temp = array[j];
                array[j] = array[k];
                array[k] = temp;
            }
        }

    }

    static int inversePairs(int[] array) {
        int[] clone = array.clone();
        int[] midResult = new int[array.length];
        for(int i=0;i<array.length;i++){
            midResult[i] = -1;
        }
        midResult[array.length-1] = 0;
        return sum(array, 0, array.length-1, midResult);
    }

    static int sum(int[] array, int start, int end, int[] midResult){
        if(array.length == 0 || array.length == 1){
            return 0;
        }
        if(midResult[start]!=-1){
            return midResult[start];
        }
        if(start<end){
            int partNum = sum(array, start+1, end, midResult);
            int num = array[start];
            int count = 0;
            for(int i=start+1;i<=end;i++){
                if(num > array[i]){
                    count++;
                }
            }
            midResult[start] = partNum + count;
            return midResult[start];
        }
        else return 0;
    }
}
