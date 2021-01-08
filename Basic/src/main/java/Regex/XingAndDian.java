package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019/7/2 8:56
 * a* 匹配多个a
 * a. 匹配一个a
 */
public class XingAndDian {
    public static void main(String[] args) {
        String target = "123aaabb123";
        String pattern = "a*a.b.b";
        myRegex(target, pattern);
    }

    static void myRegex(String target, String pattern) {
        char[] chars = pattern.toCharArray();
        StringBuilder regex = new StringBuilder();
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i+1] == '*'){
                regex.append(chars[i]).append("*");
            }
            else if (chars[i+1] == '.'){
                regex.append(chars[i]);
            }
            else if (chars[i] != '*' && chars[i] != '.'){
                regex.append(chars[i]);
            }
        }
        if (chars[chars.length-1] != '*' && chars[chars.length-1] != '.'){
            regex.append(chars[chars.length-1]);
        }

        // *************matches()*******************
        System.out.println("regex1 = " + regex.toString());
        Pattern compile = Pattern.compile(regex.toString());
        Matcher matcher = compile.matcher(target);
        System.out.println("regex1 matches: " + matcher.matches());
        matcher.find();
        String group = matcher.group();
        System.out.println("regex1 group: " + group);

        //**************loonkingAt() 以指定regex开头********************

        String t1 = "123aabbcc456";
        String p1 = "\\d+";
        Pattern compile1 = Pattern.compile(p1);
        Matcher matcher1 = compile1.matcher(t1);
        System.out.println("regex2 loonkingAt(): " + matcher1.lookingAt());

        // ****************find()***************************
        // find之后，才能使用start、end和group方法，包头不包尾
        // ***************start()和end()*************************
        // ******************group()****************************
        String t2 = "aebcbadebaaa";
        String p2 = "a.?e";
        Pattern compile2 = Pattern.compile(p2);
        Matcher matcher2 = compile2.matcher(t2);
        //System.out.println("regex3: " + matcher2.find());
        while (matcher2.find()){
            System.out.println("start: " + matcher2.start() + ", end: " + matcher2.end() + ", group: " + matcher2.group());
        }

        // *************\b 匹配单词边界************
        String str = "nice to meet you to do something";
        Pattern compile3 = Pattern.compile("\\bto\\b");
        Matcher matcher3 = compile3.matcher(str);
        while (matcher3.find()){
            System.out.println(matcher3.group());
        }
    }

}
