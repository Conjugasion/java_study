package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019/9/4 19:48
 */
public class StringReverse {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    // ((ur)oi)
    static String resolve(String expr) {
        Pattern compile1 = Pattern.compile("\\([[^(][^)]\\w]*\\)");
        boolean find = true;
        while (true){
            Matcher matcher1 = compile1.matcher(expr);
            if (matcher1.find()){
                find = false;
                String g1 = matcher1.group();
                // System.out.println(g1);                       // (ur)
                String reverse = reverse(g1.substring(1, g1.length() - 1));  // ru
                // System.out.println(reverse);
                expr = expr.replace(g1, reverse);
                //System.out.println(expr);
            }else break;
        }
        System.out.println(expr);
        if (find) return "";
        return expr;
    }
    static String reverse(String str){
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = chars.length-1; i >=0; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        resolve("((ur)oi)");
    }
}
