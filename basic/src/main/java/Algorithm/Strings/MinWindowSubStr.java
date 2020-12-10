package Algorithm.Strings;


/**
 * @author Lucas
 * @date 2019-08-14 20:39
 * 最小窗口子串
 * 已知字符串S与字符串T，求在S中的最小窗口(区间)，使得这个区间中包含字符串T中的所有字符
 * S=ADOBECODEBANC, T=ABC
 * 包含T的子区间中，有ADOBEC，CODEBA，BANC，最小区间是BANC
 */
public class MinWindowSubStr {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(hasShow(s, t));
    }

    // t中的元素是否在s中都出现过
    static boolean hasShow(String s, String t){
        int[] s_map = new int[128];
        int[] t_map = new int[128];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();

        for (int i = 0; i < ss.length; i++) {   // char类型做数组索引
            s_map[ss[i]]++;
        }
        for (int i = 0; i < tt.length; i++) {
            t_map[tt[i]]++;
        }

        for (int i = 0; i < s_map.length; i++) {
            if (s_map[i]<t_map[i]) return false;    // s_map小于t_map
        }
        return true;
    }
}
