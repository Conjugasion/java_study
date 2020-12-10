package Algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Lucas
 * @date 2019-07-22 21:32
 * 组合，从n个数字中随机选出m个数字
 */
public class Zuhe {
    public static void main(String[] args) {
        int[] array1 = {1,2,2,3,4};
        int m = 3;     // 取几个

        ArrayList<Integer> list=new ArrayList<>();
        HashSet<String> result1 = new HashSet<>();
        combine(array1,0,m,result1,list);   // C53
        System.out.println(result1);
        System.out.println("---------------------");

        // 将数组指定范围内的数字 全排列  带重复数字
        ArrayList<int[]> result2 = new ArrayList<>();
        pailie(array1,0, 4, result2);
        for (int[] i:result2) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println("----------------------");

        // 将数组指定范围内的数字 全排列  不带重复数字
        int[] array2 = {1,2,3,4};
        ArrayList<int[]> result3 = new ArrayList<>();
        pailieNoRepeated(array2,0, 3, result3);
        for (int[] i:result3) {
            System.out.println(Arrays.toString(i));
        }
    }

    // 带重复数字  组合
    static void combine(int[] arrays,int begin, int number, HashSet<String> result, ArrayList<Integer> list){
        if(number==0){
            result.add(list.toString());
            return;
        }
        if(begin==arrays.length){
            return;
        }

        list.add(arrays[begin]);
        combine(arrays, begin+1, number-1, result, list);
        list.remove((Integer) arrays[begin]);
        combine(arrays, begin+1, number, result, list);
    }




    // 排列 带重复数字 递归版
    // 将数组指定范围内的数字全排列
    static void pailie(int[] array, int from, int to, ArrayList<int[]> result){
        if (from == to) {
            int[] num = new int[to+1];
            for (int i = 0; i <= to; i++) {
                num[i] = array[i];
            }
            result.add(num);
        }
        for (int i = from; i <= to; i++) {
            boolean isSwap = true;
            for (int j = from; j < i; j++) {
                if (array[j] == array[i]){
                    isSwap = false;               // 置true 可重复排列
                }
            }
            if (isSwap){
                int s1 = array[i];
                array[i] = array[from];
                array[from] = s1;
                pailie(array, from+1, to, result);
                int s2 = array[i];
                array[i] = array[from];
                array[from] = s2;
            }
        }
    }

    // 排列 不带重复数字
    static void pailieNoRepeated(int[] array, int from, int to, ArrayList<int[]> result){
        if (from == to) {
            int[] num = new int[to+1];
            for (int i = 0; i <= to; i++) {
                num[i] = array[i];
            }
            result.add(num);
        }
        for (int i = from; i <= to; i++) {
            int s1 = array[i];
            array[i] = array[from];
            array[from] = s1;
            pailieNoRepeated(array, from+1, to, result);
            int s2 = array[i];
            array[i] = array[from];
            array[from] = s2;
        }
    }

    // C(m/n)=C((m-1)/(n-1))+C(m/(n-1))
    // 从n和数字中抽取m个
    static int fun(int n, int m) {
        if(m>n)return 0;
        if(m==0)return 1;
        return fun(n-1,m-1) + fun(n-1,m);
    }
}
