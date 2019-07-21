package algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/7/19 14:05
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *      101
 *      110
 *  -----------
 *      000
 *     101
 *    101
 *  ------------
 *    11110
 */
public class ScaleTrans {
    public static void main(String[] args) {
        int i = 5;
        String i2 = Integer.toBinaryString(i);    // 101
        System.out.println(i2);
        int j = 6;
        String j2 = Integer.toBinaryString(j);    // 110
        System.out.println(j2);
        int s = 30;
        String s2 = Integer.toBinaryString(s);    // 11110
        System.out.println(s2);

        int[] j2Int = new int[j2.length()];       // [1,1,0]
        for (int k = 0; k < j2.length(); k++) {
            j2Int[k] = Integer.valueOf(j2.charAt(k)+"")&i;
        }
        System.out.println(Arrays.toString(j2Int));
        System.out.println(Add(2,-1));
    }

    // 利用短路原理
    int duanLu(int n){
        boolean b = (n != 0) && ((n += duanLu(n - 1)) != 0);
        return n;
    }

    // 不用加减符号求两数之和
    public static int Add(int num1,int num2) {
        if (num2==0) return num1;
        int result = 1;
        result += Add(num1,num2-1);
        return result;
    }

}
