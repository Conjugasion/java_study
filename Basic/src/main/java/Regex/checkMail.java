package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther Lucas
 * @date 2019/1/3 16:23
 */
public class checkMail {
    public static void main(String[] args) {
        System.out.println(regexMail("tdf516020608@163.com"));
    }

    public static boolean regexMail(String mail){
        Pattern p = Pattern.compile("[\\w]+@[\\da-z]+(\\.[a-z]+)+");
        Matcher m = p.matcher(mail);

        return m.matches();
    }
}
