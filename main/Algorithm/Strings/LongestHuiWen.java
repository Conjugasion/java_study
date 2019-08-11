package Algorithm.Strings;

import java.util.HashMap;

/**
 * @author Lucas
 * @date 2019-08-11 14:05
 * 一个只包含大小写的字符串，求用该字符串中的字符可以生成的最长回文字符串长度
 * s=abccccddaa，可以生成最长长度为9的回文字符串，dccaaaccd
 * 哈希映射！
 */
public class LongestHuiWen {
    public static void main(String[] args) {
        String s = "abccccddaa";
        System.out.println(huiWen(s));
    }

    // 偶数个，奇数个(中心点
    static int huiWen(String s){
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> charsMap = new HashMap<>();
        for (char c : chars) {
            if (charsMap.containsKey(c)){
                charsMap.put(c, charsMap.get(c)+1);
            } else {
                charsMap.put(c, 1);
            }
        }

        boolean flag = true;      // 是否有中心点
        int length = 0;
        for (char c: charsMap.keySet()) {
            int count = charsMap.get(c);
            if (count%2==0){          // 偶数
                length += count;
            }else {                   // 奇数
                if (flag){
                    length += count;
                    flag=false;
                }else {
                    length += (count-1);
                }
            }
        }
        return length;
    }
}
