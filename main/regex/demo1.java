package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther Lucas
 * @date 2019/1/3 15:28
 */
public class demo1 {
    public static void main(String[] args) {
        System.out.println(regexQQ("1234567"));
        System.out.println(regexPhone("18201712787"));

        Pattern p = Pattern.compile("[1-9]\\d{4,9}");
        Matcher m = p.matcher("tdf516020608");
        System.out.println("lookAt :" + m.lookingAt());
        System.out.println("matches :" + m.matches());
        System.out.println("find :" + m.find());
        System.out.println("start :" + m.start());
        System.out.println("end :" + m.end());
        System.out.println("group :" + m.group());

    }

    public static boolean regexQQ(String QQ){
        boolean b = QQ.matches("[1-9]\\d{4,9}");
        return b;
    }

    public static boolean regexPhone(String phone){
        boolean b = phone.matches("[1][34578]\\d{9}");
        return b;
    }
}
