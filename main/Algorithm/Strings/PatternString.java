package Algorithm.Strings;

import java.util.HashMap;

/**
 * @author Lucas
 * @date 2019-08-11 14:22
 * 已知字符串pattern和字符串str，确认str是否和pattern匹配
 * 例如
 * pattern = abba，str = dog cat cat dog 匹配
 * pattern = abba，str = dog cat cat fish 不匹配
 */
public class PatternString {
    public static void main(String[] args) {
        String pattern = "abcd";
        String str = "dog cat cat fish";
        System.out.println(isMatch(pattern, str));
    }

    // a代表dog，b代表cat，映射
    static boolean isMatch(String pattern, String str){
        HashMap<Character, String> map = new HashMap<>();
        char[] patterns = pattern.toCharArray();
        String[] strs = str.split(" ");
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(patterns[i])){
                if (map.values().contains(strs[i])){
                    return false;                         // b、c不能同时指向cat！
                }else {
                    map.put(patterns[i], strs[i]);
                }
            }else {
                String expect = map.get(patterns[i]);
                if (!expect.equals(strs[i])){
                    return false;
                }
            }
        }
        // System.out.println(map.values());   // [dog, cat, cat, fish] 不会去重
        return true;
    }
}
