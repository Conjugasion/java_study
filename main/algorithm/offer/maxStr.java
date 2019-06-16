package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-06-16 14:33
 */
public class maxStr {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int i = find(array, 0, array.length - 1);
        System.out.println(i);
    }
    /*
    分治
     */
    static int find(int[] array, int left, int right){
        if (left >= right){
            return array[left];
        }
        int mid = (left + right)/2;
        // 在左 在右
        int m1 = find(array, left, mid);
        int m2 = find(array, mid+1, right);

        // 横跨
        int now = 0;
        int sumleft = 0;
        for (int i = mid; i >= left; i--) {
            now += array[i];
            sumleft = now > sumleft ? now:sumleft;
        }

        now = 0;
        int sumright = 0;
        for (int i = mid+1; i < right; i++) {
            now += array[i];
            sumright = now > sumright ? now:sumright;
        }
        int m3 = sumleft + sumright;
        return Math.max(m1,m2) > m3 ? Math.max(m1,m2) : m3;
    }
}
