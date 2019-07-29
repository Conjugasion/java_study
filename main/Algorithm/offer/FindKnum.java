package algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-07-24 20:31
 * 在无序数组中寻找第k小的元素
 * 输入  n 个元素的数组 A[1...n] 和整数 k，1 ≤ k ≤ n
 * 输出  A 中的第 k 小元素
 *
 * 算法描述 select(A, low, high, k)
 * 1. n ← high - low + 1----（Θ(1)）
 * 2. if  n < 44 then 将 A 排序 return (A[k])----（Θ(1)）
 * 3. 令 q =  ⌊n/5⌋。将 A 分成 q 组，每组5个元素。如果5不整除 n ，则排除剩余的元素。----（Θ(n)）
 * 4. 将 q 组中的每一组单独排序，找出中项。所有中项的集合为 M。----（Θ(n)）
 * 5. mm ← select(M, 1, q,  ⌈q/2⌉)   { mm 为中项集合的中项 } ----T(n/5)
 * 6. 将 A[low...high] 分成三组----（Θ(n)）
 *     A1 = { a | a < mm }
 *     A2 = { a | a = mm }
 *     A3 = { a | a > mm }
 * 7. case
 *     |A1| ≥ k : return select(A1, 1, |A1|, k)
 *     |A1| + |A2| ≥ k : return mm
 *     |A1| + |A2| < k : return select(A3, 1, |A3|, k - |A1| - |A2|)
 * 8. end case
 */
public class FindKnum {
    public static void main(String[] args) {
        int[] a = new int[99];  // 0 1 2 ... 98
        for (int i = 0; i < 99; i++) {
            a[i] = i;
        }
        System.out.println(select(a, 98));
    }
    public static int select(int[] A, int k){
        return selectDo(A, 0, A.length-1, k);
    }

    private static int selectDo(int[] A, int low, int high, int k){
        //select k min number
        int p = high - low + 1;
        if(p < 44){
            Arrays.sort(A, low, high+1);
            return A[low+k];
        }
        //A divided into q groups, each group 5 elements, and sort them
        int q = p/5;
        int[] M = new int[q];
        for(int i = 0; i < q; i ++){
            Arrays.sort(A, low + 5*i, low + 5*i + 5);
            M[i] = A[low+5*i+2];
        }
        //select mid in M
        int mid = selectDo(A, 0, q-1, (q-1)/2);
        //A divided into 3 groups
        int[] A1 = new int[p];
        int[] A2 = new int[p];
        int[] A3 = new int[p];
        int count1, count2, count3;
        count1 = count2 = count3 = 0;
        for(int i = low; i <= high; i ++){
            if(A[i] < mid)
                A1[count1++] = A[i];
            else if(A[i] == mid)
                A2[count2++] = A[i];
            else
                A3[count3++] = A[i];
        }
        if(count1 >= k)
            return selectDo(A1, 0, count1-1, k);
        if(count1 + count2 >= k)
            return mid;
        return selectDo(A3, 0, count3-1, k-count1-count2);
    }
}
