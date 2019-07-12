package algorithm.offer;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019/7/12 16:00
 * 全排列
 */
public class PermutationPailie {
    public static void main(String[] args) {

    }

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
        StringBuilder subStr = new StringBuilder();
        char first = chars[0];
        for (int i = 1; i < chars.length; i++) {
            subStr.append(chars[i]);
        }
        ArrayList<String> subList = Permutation(subStr.toString());
        ArrayList<String> result = new ArrayList<>();
        for (String s : subList) {
            char[] subChars = s.toCharArray();
            for (int i = 0; i <= subChars.length; i++) {

            }
        }
        return result;
    }
}
