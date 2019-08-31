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
        int[] array = {1,2,2,3,4};
        int m = 3;

        ArrayList<Integer> list=new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        combine(array,0,3,result,list);   // C53
        System.out.println(result);

        // 将数组指定范围内的数字 全排列
        ArrayList<int[]> result1 = new ArrayList<>();
        pailie(array,0, 4, result1);
        for (int[] i:result1) {
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

    // C(m/n)=C((m-1)/(n-1))+C(m/(n-1))
    // 从n和数字中抽取m个
    static int fun(int n, int m) {
        if(m>n)return 0;
        if(m==0)return 1;
        return fun(n-1,m-1) + fun(n-1,m);
    }
}
