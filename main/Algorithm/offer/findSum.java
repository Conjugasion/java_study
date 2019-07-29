package Algorithm.offer;

import java.util.HashMap;

/**
 * @author Lucas
 * @date 2019/7/19 19:51
 * 在一个数组中找到和为给定值的两个数
 */
public class findSum {
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 5, 7, 10};
        int target = 9;
        HashMap<Integer, Integer> arrayMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!arrayMap.containsKey(array[i])){
                arrayMap.put(array[i], i);
            }
            if (arrayMap.containsKey(target - array[i])){
                System.out.println(arrayMap.get(array[i]) + "和" + arrayMap.get(target-array[i]));
                break;
            }
        }
    }
}
