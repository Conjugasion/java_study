package Algorithm.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * @author Lucas
 * @date 2019-08-11 16:07
 * 最长无重复子串
 * 已知一个字符串，求用该字符串的无重复字符的最长子串长度
 * 例如
 * abcabcbb --> "abc" 3
 * bbbbb --> b 1
 * pwwkew --> wke 3
 */
public class NoRepeatedSubStr {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            char[] c = new char[10];
            for (int j = 0; j < 10; j++) {
                c[j] = (char)(r.nextInt(26)+65);
            }
            String str = new String(c);
            System.out.println("字符串：" + str);
            System.out.println("动态规划法：" + longLength(str));
            System.out.println("双指针法：" + pointer(str));
            System.out.println("--------------");
        }
    }

    // dp[i] 表示以第i个元素结尾的最长子串长度
    // 如果第i个元素左侧从未出现过第i个元素，dp[i] = dp[i-1]+1
    // 如果出现过，则计算gap
    // 如果gap<=dp[i-1], dp[i] = gap; 否则 dp[i] = dp[i-1]+1
    static int longLength(String str){
        int[] dp = new int[str.length()];
        char[] chars = str.toCharArray();
        ArrayList<Character> appear = new ArrayList<>();   // 记录已出现过的字符及其位置

        appear.add(chars[0]);
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            if (!appear.contains(chars[i])){
                dp[i] = dp[i-1]+1;
            }else {
                int gap = i - appear.lastIndexOf(chars[i]);
                if (gap <= dp[i-1]) {
                    dp[i] = gap;
                }else {
                    dp[i] = dp[i-1]+1;
                }
            }
            appear.add(chars[i]);
            max = max >= dp[i] ? max : dp[i];
        }
        return max;
    }

    // 双指针，当后面一个指针碰到重复字符时，前一个指针要移动到重复字符的后一个字符
    // O(n)时间复杂度
    static int pointer(String str){
        char[] chars = str.toCharArray();
        int begin = 0;
        ArrayList<Character> appear = new ArrayList<>();   // 记录已出现过的字符及其位置
        HashMap<Integer, Integer> lengthMap = new HashMap<>();  // [begin: length]

        for (int k = 0; k < chars.length; k++) {

            if (!appear.contains(chars[k])){
                if (!lengthMap.containsKey(begin)){
                    lengthMap.put(begin, 1);
                }else {
                    lengthMap.put(begin, lengthMap.get(begin)+1);
                }
            }else {
                begin = appear.lastIndexOf(chars[k])+1;
                lengthMap.put(begin, k-begin+1);
            }
            appear.add(chars[k]);
        }

        int max = 1;
        for (int j:lengthMap.keySet()) {
            max = max >= lengthMap.get(j) ? max : lengthMap.get(j);
        }
        return max;
    }
}
