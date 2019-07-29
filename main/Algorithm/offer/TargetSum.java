package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-22 21:06
 * 给定一系列数字，找出和为target所有组合的数量
 */
public class TargetSum {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 8, 1, 4};
        int target = 5;
        int i = manyTimes(array, target, 5);
        // 2+3,1+4,2+2+1,2+1+1+1,3+1+1,5*1,5
        System.out.println("一个数字能用多次 " + i);
        //System.out.println(String.format("%.4f",1.2));
        int j = onlyOne(array, target, 5);
        // 2+3,1+4,5
        System.out.println("一个数字只能用一次 " + j);
    }

    // 数组，target，选用前n个数字
    // 一个数字能用多次
    static int manyTimes(int[] array, int target, int n){
        if (target==0) return 1;
        if (target<0||n<0) return 0;
        return manyTimes(array, target, n-1) + manyTimes(array, target-array[n], n);
    }

    // 数组，target，选用前n个数字
    // 一个数字只能用一次
    static int onlyOne(int[] array, int target, int n){
        if (target==0) return 1;
        if (target<0||n<0) return 0;
        return onlyOne(array, target, n-1) + onlyOne(array, target-array[n], n-1);
    }

}
