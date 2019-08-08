package Algorithm.offer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019/8/8 16:36
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".。
 */
public class DecodeString {
    public static void main(String[] args) {
        System.out.println(regex("3[a]2[b4[F]c]"));
    }

    // 正则匹配
    static String regex(String s){
        Pattern compile1 = Pattern.compile("\\d+\\[[a-zA-Z]+\\]");
        Pattern compile2 = Pattern.compile("\\d+");
        Pattern compile3 = Pattern.compile("[a-zA-Z]+");

        while (true){
            Matcher matcher1 = compile1.matcher(s);
            if (matcher1.find()){
                String g1 = matcher1.group();
                System.out.println(g1);                       // 3[a]

                Matcher matcher2 = compile2.matcher(g1);
                matcher2.find();
                int num = Integer.valueOf(matcher2.group());
                System.out.println(num);                      // 3

                Matcher matcher3 = compile3.matcher(g1);
                matcher3.find();
                String letter = matcher3.group();
                StringBuilder letters = new StringBuilder(letter);

                for (int i = 1; i < num; i++) {
                    letters.append(letter);
                }
                System.out.println(letters);                   // aaa

                s = s.replace(g1, letters);
            }else break;
        }
        return s;
    }
}
