package algorithm.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucas
 * @date 2019-06-09 12:59
 * 切钢条，使获得利润最大
 */
public class dynamic2 {
    public static void main(String[] args) {
        Map<Integer, Integer> price = new HashMap<>();
        price.put(1, 1);
        price.put(2, 5);
        price.put(3, 8);
        price.put(4, 9);
        price.put(5, 10);
        price.put(6, 17);
        price.put(7, 17);
        price.put(8, 20);
        price.put(9, 24);
        price.put(10, 30);
        System.out.println(cut(price, 4));

        Map<Integer, Integer> midResult = new HashMap<>();
        for (int i = 1; i <= 10; i++) {
            midResult.put(i, -1);
        }
        System.out.println(cut(price, midResult, 4));

    }

    /*
    纯递归版本
     */
    static int cut(Map<Integer, Integer> price, int n){
        if (n==0){
            return 0;
        }
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value = Math.max(value, price.get(i) + cut(price, n-i));
        }
        return value;
    }
    /*
    记忆型递归(备忘录版本)
     */
    static int cut(Map<Integer, Integer> price, Map<Integer, Integer> midResult, int n){
        if (n==0){
            midResult.put(n, 0);
        }
        if (midResult.get(n) != -1){
            return midResult.get(n);
        }
        int value = 0;
        for (int i = 1; i <= n; i++) {
            value = Math.max(value, price.get(i) + cut(price, n-i));
        }
        midResult.put(n, value);
        return midResult.get(n);
    }

    /*
    递推，自底向上的动态规划
     */
    static int cut(int n, Map<Integer, Integer> price, Map<Integer, Integer> midResult){
        return 1;
    }
}
