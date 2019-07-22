package algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-07-22 21:32
 * 组合，从n个数字中随机选出m个数字
 */
public class Zuhe {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int m = 2;
        ArrayList<int[]> compose = compose(array, m);
        for (int[] i:compose) {
            System.out.println(Arrays.toString(i));
        }
    }

    static ArrayList<int[]> compose(int[] array, int m){
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                int[] twoNums = {array[i], array[j]};
                result.add(twoNums);
            }
        }
        return result;
    }
}
