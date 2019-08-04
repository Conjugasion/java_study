package Algorithm.recursion;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-08-03 20:28
 * 已知一组集合(不重复)，求这组数可以组成的所有子集，子集不能有重复
 * num = {1,2,3}
 * subSet = {{},{1},{2},{3},{1,2},{1,3},{2,3},{1,2,3}}
 */
public class SubSet {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        ArrayList<ArrayList<Integer>> result1 = new ArrayList<>();
        ArrayList<Integer> item1 = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            item1.add(num[i]);
            ArrayList<Integer> copy = (ArrayList<Integer>)item1.clone();
            result1.add(copy);
        }
        System.out.println("循环 从[1，2，3]生成[1],[1,2],[1,2,3]" + result1);

        ArrayList<ArrayList<Integer>> result2 = new ArrayList<>();
        ArrayList<Integer> item2 = new ArrayList<>();
        findSubSet(0, num, item2, result2);
        System.out.println("递归 从[1，2，3]生成[1],[1,2],[1,2,3]" + result2);

        ArrayList<ArrayList<Integer>> result3 = new ArrayList<>();
        result3.add(new ArrayList<>());
        ArrayList<Integer> item3 = new ArrayList<>();
        huiSu(0, num, item3, result3);
        System.out.println("回溯 全子集" + result3);

        ArrayList<ArrayList<Integer>> result4 = new ArrayList<>();
        smart(num, result4);
        System.out.println("位与 全子集" + result4);

    }

    // 从[1，2，3]生成[1],[1,2],[1,2,3]
    static void findSubSet(int i, int[] num, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
        if (i>=num.length){
            return;
        }
        item.add(num[i]);
        ArrayList<Integer> copy = (ArrayList<Integer>)item.clone();
        result.add(copy);
        findSubSet(i+1, num, item, result);
    }

    // 回溯法，放1还是不放1
    static void huiSu(int i, int[] num, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result){
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

    // 使用位运算，001表示仅放入c，...
    // i&4=4表示存在A，i&2=2表示存在B，i&1=1表示存在C
    static void smart(int[] num, ArrayList<ArrayList<Integer>> result){
        int sum = (int) Math.pow(2,num.length);
        for (int i = 0; i < sum; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            if ((i&4)==4){
                item.add(num[0]);
            }
            if ((i&2)==2){
                item.add(num[1]);
            }
            if ((i&1)==1){
                item.add(num[2]);
            }
            result.add(item);
        }
    }
}
