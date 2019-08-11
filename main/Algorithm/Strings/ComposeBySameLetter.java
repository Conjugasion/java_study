package Algorithm.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Lucas
 * @date 2019-08-11 14:45
 * 已知一组数组，将所有相同字母构成的字符放到一起
 * 例如
 * [eat, tea, tan, ate, nat, bat]
 * [[eat, tea, ate], [tan, nat], [bat]]
 */
public class ComposeBySameLetter {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[][] anagram = anagram(strs);
        System.out.println(Arrays.deepToString(anagram));

    }

    // 映射
    static String[][] anagram(String[] strs){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        char[] chars = null;
        for (String s:strs) {
            chars = s.toCharArray();
            Arrays.sort(chars);                   // 排序char
            String sortStr = new String(chars);   // char[]重组String
            if (!map.containsKey(sortStr)){
                map.put(sortStr, new ArrayList<String>(){{add(s);}});
            }else {
                map.get(sortStr).add(s);
            }
        }
        String[][] result = new String[map.size()][];
        int n = 0;
        for (String c:map.keySet()) {
            result[n] = new String[map.get(c).size()];
            for (int i = 0; i < result[n].length; i++) {
                result[n][i] = map.get(c).get(i);
            }
            n++;
        }
        return result;
    }
}
