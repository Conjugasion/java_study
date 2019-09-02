package Algorithm.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 15:28
 */
public class Expect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int j = 1; j <= x; j++) {
                nums.add(j);
            }
            map.put(i, nums);
        }
        //System.out.println(map);
        double possible = 1;
        for (int key:map.keySet()) {
            double poss = 1.0/map.get(key).size();
            possible *= poss;
        }
        //System.out.println(possible);
        ArrayList<ArrayList<Integer>> compose = compose(map);
        //System.out.println(compose);
        ArrayList<Integer> sum = new ArrayList<>();
        for (ArrayList<Integer> c:compose) {
            Collections.sort(c);
            sum.add(c.get(c.size()-1));
        }
        //System.out.println(sum);
        double expectNum = 0;
        for (int i:sum) {
            expectNum += possible*(double) i;
        }
        System.out.println(String.format("%.2f", expectNum));
    }

    // 组合
    static ArrayList<ArrayList<Integer>> compose(HashMap<Integer, ArrayList<Integer>> map){
        if (map.keySet().size()<=0) return null;
        if (map.keySet().size()==1){
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            for (int key:map.keySet()) {
                ArrayList<Integer> nums = map.get(key);
                for (int num:nums) {
                    result.add(new ArrayList<Integer>(){{add(num);}});
                }
            }
            return result;
        }
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());
        int last = keys.remove(keys.size() - 1);
        ArrayList<Integer> remove = map.remove(last);
        ArrayList<ArrayList<Integer>> compose = compose(map);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (ArrayList<Integer> c:compose) {
            for (int ele:remove) {
                ArrayList<Integer> copy = (ArrayList<Integer>)c.clone();
                copy.add(ele);
                result.add(copy);
            }
        }
        return result;
    }
}
