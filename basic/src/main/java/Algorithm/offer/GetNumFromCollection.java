package Algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-09-01 17:10
 * 从n个集合中取n个数，每个集合只能取一个数字
 */
public class GetNumFromCollection {
    public static void main(String[] args) {
        String[] arr1 = { "1", "2","3"};
        String[] arr2 = { "a", "b","c"};
        String[] arr3 = { "A","B","G"};
        List<String[]> list = new ArrayList<>();
        list.add(arr1);
        list.add(arr2);
        list.add(arr3);
        ArrayList<String> result = new ArrayList<>();
        test(list, arr1, "", result);
        System.out.println(result);
    }

    public static void test(List<String[]> list, String[] arr, String str, ArrayList<String> result) {
        for (int i = 0; i < list.size(); i++) {
            //取得当前的数组
            if (i == list.indexOf(arr)) {
                //迭代数组
                for (String st : arr) {
                    st = str + st;
                    if (i < list.size() - 1) {
                        test(list, list.get(i + 1), st, result);
                    }
                    else if (i == list.size() - 1) {
                        result.add(st);
                    }
                }
            }
        }
    }
}
