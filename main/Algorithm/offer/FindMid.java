package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-24 19:53
 * 两个排序数组中找中位数
 */
public class FindMid {
    public static void main(String[] args) {
        int[] a1 = {2, 5, 8, 11};
        int[] a2 = {1, 3, 5, 7, 9, 11};
        System.out.println(useMerge(a1,a2));
    }

    // 归并排序的思想,merge到中位数
    static float useMerge(int[] a1, int[] a2){
        int length = a1.length + a2.length;
        int[] result = new int[length];
        int i=0,j =0;
        int n = 0;
        int end = length/2;

        while (i<a1.length&&j<a2.length){
            if (n==end+1) break;
            if (a1[i]<=a2[j]){
                result[n] = a1[i];
                i++;
                n++;
            }else {
                result[n] = a2[j];
                j++;
                n++;
            }
        }
        if (i<a1.length){
            for (int k = i; k < a1.length; k++) {
                if (n==end+1) break;
                result[n] = a1[i];
                i++;
                n++;
            }
        }
        if (j<a2.length){
            for (int k = j; k < a2.length; k++) {
                if (n==end+1) break;
                result[n] = a2[j];
                j++;
                n++;
            }
        }
        if (length%2==0){
            return (result[end]+result[end-1])/2.0f;
        }else {
            return result[end];
        }

    }
}
