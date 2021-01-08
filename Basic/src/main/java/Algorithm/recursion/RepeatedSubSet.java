package Algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Lucas
 * @date 2019-08-03 22:11
 * 已知一组集合(有重复)，求这组数可以组成的所有子集，子集不能有重复
 * num = {2，1，2，2}
 * subSet = {{},{1},{1，2},{1，2，2},{1,2，2，2},{2},{2,2},{2,2,2}}
 */
public class RepeatedSubSet {
    public static void main(String[] args) {
        int[] num = {2,1,2,2};
        Arrays.sort(num);      // 排序num
        HashSet<ArrayList<Integer>> result = new HashSet<>();
        ArrayList<Integer> item = new ArrayList<>();
        huiSu(0, num, item, result);
        System.out.println(result);
    }

    // 回溯法，放1还是不放1，使用HashSet去重
    static void huiSu(int i, int[] num, ArrayList<Integer> item, HashSet<ArrayList<Integer>> result){
        if (i>=num.length){
            return;
        }
        item.add(num[i]);    // 放入
        ArrayList<Integer> copy = (ArrayList<Integer>)item.clone();
        result.add(copy);   // 将当前item假如result
        huiSu(i+1, num, item, result);
        item.remove((Integer) num[i]);   // 不放入，即移除已放入的num[i]
        huiSu(i+1, num, item, result);
    }
}
