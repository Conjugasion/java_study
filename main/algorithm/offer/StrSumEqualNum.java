package algorithm.offer;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-07-16 20:12
 * 和为S的连续正数序列
 */
public class StrSumEqualNum {
    public static void main(String[] args) {
        System.out.println(allStr(50));
        System.out.println(check(50));
    }

    // 筛选那些ArrayList的 和 是target
    static ArrayList<ArrayList<Integer>> check(int sum){
        if (sum==0||sum==1||sum==2){
            return new ArrayList<ArrayList<Integer>>();
        }
        if (sum==3){
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(1);
            sub.add(2);
            result.add(sub);
            return result;
        }
        int mid = sum/2;
        ArrayList<ArrayList<Integer>> lists = allStr(mid);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> l:lists) {
            int all = 0;
            for (int i:l) {
                all += i;
            }
            if (all == sum){
                result.add(l);
            }
        }
        if (sum%2!=0) result.add(new ArrayList<Integer>(){{add(mid);add(mid+1);}});
        return result;
    }


    // 指定范围之内的所有序列,num为target/2
    static ArrayList<ArrayList<Integer>> allStr(int num){
        if (num==2){
            ArrayList<ArrayList<Integer>> all = new ArrayList<>();
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(1);
            sub.add(2);
            all.add(sub);
            return all;
        }
        else {
            ArrayList<ArrayList<Integer>> preNum = allStr(num-1);
            ArrayList<ArrayList<Integer>> nowNum = new ArrayList<>();
            for(ArrayList<Integer> i:preNum){
                nowNum.add((ArrayList<Integer>)i.clone());
                if(i.contains(num-1)){
                    i.add(num);
                    nowNum.add(i);
                }
            }
            nowNum.add(new ArrayList<Integer>(){{add(num-1);add(num);}});
            return nowNum;
        }
    }
}
