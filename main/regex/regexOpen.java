package regex;

import java.awt.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019-06-01 17:26
 */
public class regexOpen {
    public static void main(String[] args) {
        String regex = "\\b[a-zA-Z]+\\b";
        String str = "sdfas dbqwe";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }

        String john = "qwe123asdf123qwe46asd";
        Pattern digit = Pattern.compile("\\d+");
        String[] split1 = digit.split(john);
        System.out.println(Arrays.toString(split1));
        String[] split2 = john.split("\\d+");
        System.out.println(Arrays.toString(split2));

        Pattern pattern3 = Pattern.compile("\\b呵呵\\b");
        Matcher matcher1 = pattern3.matcher(",,,,呵呵,,,,,,,,呵呵,,,,");
        System.out.println(matcher1.groupCount()); // 带（）时使用

        while (matcher1.find()){    // 类似于迭代器
            System.out.println(matcher1.group());
        }



    }
}
