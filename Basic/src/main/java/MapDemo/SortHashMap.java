package MapDemo;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/8/26 14:19
 * 对HashMap进行排序
 */
public class SortHashMap {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(1);
        list3.add(1);
        list3.add(2);
        map.put(1, list1);
        map.put(2, list2);
        map.put(3, list3);
        System.out.println("map未排序前");
        for (int i:map.keySet()) {
            System.out.println(map.get(i));
        }
        System.out.println("map按照ArrayList长度排序");
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());    // 转成ArrayList！
        Collections.sort(keys, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).size()-map.get(o2).size();
            }
        });
        for (int i:keys) {
            System.out.println(map.get(i));
        }
    }
}
