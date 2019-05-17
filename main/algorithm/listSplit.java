package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Lucas
 * @date 2018/12/29 18:37
 */
 class listSplit {
    private static List<List<String>> split(List<String> list, int interval){
        List<List<String>> result = new ArrayList<>();
        int size = list.size();
        int i = size/interval;
        for (int j = 0; j < i; j++) {
            List<String> debris = new ArrayList<>();
            for (int k = interval*j; k < interval*(j+1); k++) {
                debris.add(list.get(k));
            }
            result.add(debris);
        }
        // 剩下的部分
        if (size-i*interval != 0){
            List<String> restDebris = new ArrayList<>();
            for (int m = i*interval; m < size; m++) {
                restDebris.add(list.get(m));
            }
            result.add(restDebris);
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
//        list.add("f");
//        list.add("g");
//        list.add("h");

        System.out.println(split(list,3));

    }
}
