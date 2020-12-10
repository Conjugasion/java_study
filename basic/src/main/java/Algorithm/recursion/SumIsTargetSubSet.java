package Algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Lucas
 * @date 2019-08-04 12:29
 * 已知一组数(有重复元素)，求这组数可以组成的所有子集中，子集元素和为target的子集，结果中无重复子集
 * 比如 nums = [10,1,2,7,6,1,5], target = 8
 * 结果为[[1,7], [1,2,5], [2,6], [1,1,6]]
 */
public class SumIsTargetSubSet {
    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(nums);      // 排序num
        HashSet<ArrayList<Integer>> result1 = new HashSet<>();
        ArrayList<Integer> item1 = new ArrayList<>();
        huiSu(0, nums, target, item1, result1);
        System.out.println("普通回溯法：" + result1);

        HashSet<ArrayList<Integer>> result2 = new HashSet<>();
        ArrayList<Integer> item2 = new ArrayList<>();
        huiSu(0, nums, target, 0, item2, result2);
        System.out.println("回溯+剪枝：" + result2);
    }

    // 将所有不重复的子集都找出来，然后筛选出和为target的子集
    static void huiSu(int i, int[] nums, int target, ArrayList<Integer> item, HashSet<ArrayList<Integer>> result){
        if (i>=nums.length){
            return;
        }
        item.add(nums[i]);
        ArrayList<Integer> copy = (ArrayList<Integer>)item.clone();
        int sum = 0;
        for (int j = 0; j < copy.size(); j++) {    // 筛选
            sum += copy.get(j);
        }
        if (sum==target) result.add(copy);
        huiSu(i+1, nums, target, item, result);
        item.remove((Integer)nums[i]);
        huiSu(i+1, nums, target, item, result);
    }

    // 剪枝  sum为当前子集item中的元素和
    static void huiSu(int i, int[] nums, int target, int sum, ArrayList<Integer> item, HashSet<ArrayList<Integer>> result){
        if (i>=nums.length||sum>target) return;
        sum += nums[i];
        item.add(nums[i]);
        ArrayList<Integer> copy = (ArrayList<Integer>)item.clone();
        if (sum==target) result.add(copy);
        huiSu(i+1, nums, target, sum, item, result);
        item.remove((Integer)nums[i]);
        sum -= nums[i];
        huiSu(i+1, nums, target, sum, item, result);
    }
}
