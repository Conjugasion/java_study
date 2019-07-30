package Algorithm.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author Lucas
 * @date 2019-07-14 13:19
 */
public class UglyNum {
    public static void main(String[] args) {
        UglyNum uglyNum = new UglyNum();
        //System.out.println(uglyNum.GetUglyNumber_Solution(1500));
        HashSet<Integer> nums = uglyNum.findNum(1500);  //2147483647
        System.out.println(Collections.max(nums));

    }
    public long GetUglyNumber_Solution(int index) {
        HashSet<Long> num = new HashSet<>();
        num.add(1L);
        for(int i=1;i<=28;i++){
            num.addAll(multi(i));
        }
        ArrayList<Long> result = new ArrayList<>(num);
        Collections.sort(result);
        return result.get(index-1);
    }

    // 第n个丑数及其之前的丑数
    // 1 2 3 4 5 6 8 9 10 12 15
    HashSet<Integer> findNum(int n){
        if (n<=6){
            HashSet<Integer> result = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                result.add(i);
            }
            return result;
        }
        HashSet<Integer> preNumSet = findNum(n - 1);
        ArrayList<Integer> preNumList = new ArrayList<>(preNumSet);
        Collections.sort(preNumList);
        int curMax = Collections.max(preNumSet);
        HashSet<Integer> numSet = new HashSet<>(preNumSet);
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min5 = Integer.MAX_VALUE;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag5 = true;

        for (int i:preNumList){
            if (2*i > curMax && flag2){
                min2 = 2*i;
                flag2 = false;
            }
            if (3*i > curMax && flag3){
                min3 = 3*i;
                flag3 = false;
            }
            if (5*i > curMax && flag5){
                min5 = 5*i;
                flag5 = false;
            }
        }
        numSet.add(Math.min(min2, Math.min(min3, min5)));
        return numSet;
    }


    // 2，3，5中任取n个数，乘积
    // 这个太蠢了。。。
    HashSet<Long> multi(int n){
        if (n==1){
            HashSet<Long> result = new HashSet<>();
            result.add(2L);
            result.add(3L);
            result.add(5L);
            return result;
        }
        else {
            HashSet<Long> lastResult = multi(n-1);
            HashSet<Long> result = new HashSet<>();
            for(long i:lastResult){
                result.add(i*2);
                result.add(i*3);
                result.add(i*5);
            }
            return result;
        }
    }
}
