package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-15 21:51
 */
public class count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int count = 0;
        for (char c:chars) {
            if(c=='?') count++;
        }
        ArrayList<String> list = new ArrayList<>();
        toNum(s, count, list);
        long x = 0;
        for (String num:list) {
            if (Long.valueOf(num)%13==5) x++;
        }
        System.out.println(x%1000000007);
    }

    static void toNum(String s, int count, ArrayList<String> result){
        if (count==0) return ;
        toNum(s, count - 1, result);
        for (String str:result) {
            for (int i = 0; i <= 9; i++) {
                result.add(str.replaceFirst("\\?", String.valueOf(i)));
            }
        }
    }
}
