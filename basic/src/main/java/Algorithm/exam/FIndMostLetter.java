package Algorithm.exam;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Lucas
 * @date 2019-09-07 18:39
 */
public class FIndMostLetter {

    // A3bc2X-b2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        Pattern compile1 = Pattern.compile("[a-z]-[a-z]");
        Pattern compile2 = Pattern.compile("[a-z]+\\d+");
        Pattern compile3 = Pattern.compile("[a-z]\\d+-");

        while (true){
            Matcher matcher3 = compile3.matcher(s);
            while (matcher3.find()){
                String g3 = matcher3.group();
                //System.out.println(g3);                       // X10-
                String transfer3 = transfer2(g3);               // xxxxx
                s = s.replace(g3, transfer3);
            }

            Matcher matcher1 = compile1.matcher(s);
            while (matcher1.find()){
                String g1 = matcher1.group();
                //System.out.println(g1);                       // X-b
                String transfer1 = transfer1(g1);               // xyzab
                s = s.replace(g1, transfer1);
            }
            Matcher matcher2 = compile2.matcher(s);
            while (matcher2.find()){
                String g2 = matcher2.group();
                //System.out.println(g2);                      // a3
                String transfer2 = transfer2(g2);            // aaa
                s = s.replace(g2, transfer2);
            }
            break;
        }
        System.out.println(count(s));

    }

    static String count(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else {
                map.put(c, 1);
            }
        }
        int max = 0;
        for (char key:map.keySet()) {
            max = max >= map.get(key) ? max : map.get(key);
        }
        for (char key:map.keySet()) {
            if (map.get(key)==max) return String.valueOf(key)+max;
        }
        return null;
    }

    static String transfer1(String str){
        char[] chars = str.toCharArray();   // ['x', '-', 'b']
        char start = chars[0];
        char end = chars[2];
        StringBuilder string = new StringBuilder();
        if (start<=end){
            for (char i = start; i <= end; i++) {
                string.append(i);
            }
        }else {
            for (char i = start; i <= 'z'; i++) {
                string.append(i);
            }
            for (char i = 'a'; i <= end; i++) {
                string.append(i);
            }
        }
        return string.toString();
    }

    static String transfer2(String str){
        Pattern compile1 = Pattern.compile("\\d+");
        Matcher matcher1 = compile1.matcher(str);
        matcher1.find();
        int count = Integer.valueOf(matcher1.group());

        Pattern compile2 = Pattern.compile("[a-z]+");
        Matcher matcher2 = compile2.matcher(str);
        matcher2.find();
        String sub = matcher2.group();

        StringBuilder string = new StringBuilder();
        for (int i = 0; i < count; i++) {
            string.append(sub);
        }
        return string.toString();
    }
}
