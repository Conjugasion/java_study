package Algorithm.offer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Lucas
 * @date 2019/7/12 16:00
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class PermutationPailie {
    public static void main(String[] args) {
        ArrayList<String> pailie = Permutation("abcc");
        System.out.println(pailie);
    }

    static ArrayList<String> Permutation(String str) {
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
                if (!result.contains(s+first)){
                    result.add(s+first);
                }
                char[] sub = s.toCharArray();
                for (int i = 0; i < sub.length; i++) {
                    StringBuilder subStr = new StringBuilder();
                    for (int j = 0; j < sub.length; j++) {
                        if (j==i){
                            subStr.append(first);
                        }
                        subStr.append(sub[j]);
                    }
                    if (!result.contains(subStr.toString())){
                        result.add(subStr.toString());
                    }
                }
            }
            result.sort(new Comparator<String>(){
                public int compare(String o1, String o2){
                    return o1.compareTo(o2);
                }
            });
            return result;
        }
        else if (str.length() == 1){
            return new ArrayList<String>(){{add(str);}};
        }
        else return new ArrayList<String>();
    }
}
