package Algorithm.offer;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/12/5 14:57
 * 找最长回文字符串
 * ABBAQWE --- ABBA
 * ABCBABQWE --- ABCBA
 */
public class HuiWen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int max = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String subStr = str.substring(i,j);
                if (isHuiWen(subStr)&&subStr.length()>max) {
                    max = subStr.length();
                    result = subStr;
                }
            }
        }
        System.out.println(result);
    }

    static boolean isHuiWen(String str){
        int len = str.length();
        for (int i = 0,j = len-1; i <= j; i++,j--) {
            if (str.charAt(i)!=str.charAt(j)) return false;
        }
        return true;
    }
}
