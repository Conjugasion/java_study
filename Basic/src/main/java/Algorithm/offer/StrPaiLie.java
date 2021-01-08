package Algorithm.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucas
 * @date 2019-07-13 15:06
 * String.compareTo : [abc, acb, az, bac, bca, cab, cba, z, za]
 */
public class StrPaiLie {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a","1");
        map.put("b","2");
        map.put("c","1");
        boolean a = map.containsKey("a");
        System.out.println(a);
        boolean b = map.containsValue("1");
        System.out.println(b);
        String str = "abc";
        ArrayList<String> permutation = Permutation(str);
        System.out.println(permutation);
    }

    public static ArrayList<String> Permutation(String str) {
        if (str.length()>1){
            char[] all = str.toCharArray();
            char first = all[0];

            StringBuilder secStr = new StringBuilder();
            for (int i = 1; i < all.length; i++) {
                secStr.append(all[i]);
            }
            ArrayList<String> secList = Permutation(secStr.toString());
            ArrayList<String> result = new ArrayList<>();
            for (String s:secList) {
                result.add(s+first);
                char[] sub = s.toCharArray();
                for (int i = 0; i < sub.length; i++) {
                    StringBuilder subStr = new StringBuilder();
                    for (int j = 0; j < sub.length; j++) {
                        if (j==i){
                            subStr.append(first);
                        }
                        subStr.append(sub[j]);
                    }
                    result.add(subStr.toString());
                }
            }
            result.add("z");
            result.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            return result;
        }
        else if (str.length() == 1){
            return new ArrayList<String>(){{add(str);}};
        }
        else return null;
    }
}
