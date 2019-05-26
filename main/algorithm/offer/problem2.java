package algorithm.offer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019-05-26 15:31
 * 替换空格
 */
public class problem2 {
    public static void main(String[] args) {
//        StringBuffer str = new StringBuffer();
//        str.append("hello world");
//        String substring = str.substring(0, 6);
//        System.out.println(substring);
//        int i = str.indexOf("ll");  // 不存在返回-1
//        System.out.println(i);
//        str.replace(i,i+2, "LL");
//        System.out.println(str);
//        String asd = "char";
//        int c = asd.indexOf("c");
//        System.out.println(c);
        System.out.println(replaceSpace(new StringBuffer("hello world")));
        System.out.println(regexReplace(new StringBuffer("hello world")));
    }

    static String replaceSpace(StringBuffer str){
        String s = str.toString();
        String result = s.replaceAll(" ", "%20");
        return result;
    }

    static String regexReplace(StringBuffer str){
        String regEX = "\\s";
        Pattern compile = Pattern.compile(regEX);
        Matcher matcher = compile.matcher(str);
        System.out.println(matcher.find());
        String s = matcher.replaceAll("%20");
        return s;
    }
}








