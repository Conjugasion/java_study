package Algorithm.offer;

import java.util.*;


/**
 * @author Lucas
 * @date 2019-07-14 16:57
 * 逆序对
 */
public class NiXuDui {
    public static void main(String[] args) {
        /*int[] array = new int[9700];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length-i;
        }*/
        //System.out.println(InversePairs(array));
        int[] array = {1,2,3,4,5,6,7,0,-1};
        System.out.println(part(array, 0, array.length-1));
    }

    public static int InversePairs(int [] array) {
        int[] clone = array.clone();
        //return sum(array)%1000000007;
        int[] midResult = new int[array.length];
        for(int i=0;i<array.length;i++){
            midResult[i] = -1;
        }
        midResult[array.length-1] = 0;
        return sum(array, 0, array.length-1, midResult)%1000000007;
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

    static int sum(int[] array){
        if (array.length == 0 || array.length == 1){
            return 0;
        }
        if (array.length == 2){
            if (array[0]>array[1]){
                return 1;
            }
            else {
                return 0;
            }
        }
        int[] subArray = Arrays.copyOfRange(array, 1, array.length);
        int partNum = InversePairs(subArray);
        int count = 0;
        for (int i:subArray){
            if(array[0] > i){
                count++;
            }
        }
        return partNum + count;
    }

    // 归并思想
    static int part(int[] array, int left, int right){
        if (array.length==0||array.length==1) return 0;
        if (left < right){
            int mid = (left+right)/2;
            int leftSum = part(array, left, mid);
            int rightSum = part(array, mid+1, right);
            int mergeSum = merge(array, left, mid, right);
            return (leftSum+rightSum+mergeSum);
        }
        return 0;
    }

    static int merge(int[] array, int left, int mid, int right){
        int i = mid;
        int j = right;
        int[] temp = new int[right-left+1];
        int n = right-left;
        int count = 0;

        while (i>=left&&j>=mid+1){
            if (array[j] < array[i]){
                temp[n] = array[i];
                i--;
                n--;
                count++;
            }
            else {
                temp[n] = array[j];
                j--;
                n--;
            }
        }
        if (i>=left){
            for (int k = i; k >= left; k--) {
                temp[n] = array[k];
                n--;
            }
        }
        if (j>=mid+1){
            for (int k = j; k >= mid+1; k--) {
                temp[n] = array[k];
                n--;
            }
        }
        for (int k = 0; k <= right-left; k++) {
            array[k+left] = temp[k];
        }
        return count;
    }
}
