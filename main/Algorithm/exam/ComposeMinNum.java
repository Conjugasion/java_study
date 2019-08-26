package Algorithm.exam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/20 19:31
 */
public class ComposeMinNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        ArrayList<BigInteger> all = new ArrayList<>();
        pailie(str, 0, str.length-1, all);
        Collections.sort(all);
        System.out.println(all.get(0));
    }

    static void pailie(String[] str, int from, int to, ArrayList<BigInteger> all){
        if (from == to) {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i <= to; i++) {
                s.append(str[i]);
            }
            all.add(new BigInteger(s.toString()));
        }
        for (int i = from; i <= to; i++) {
            boolean isSwap = true;
            for (int j = from; j < i; j++) {
                if (str[j] == str[i]){
                    isSwap = false;
                }
            }
            if (isSwap){
                String s1 = str[i];
                str[i] = str[from];
                str[from] = s1;
                pailie(str, from+1, to, all);
                String s2 = str[i];
                str[i] = str[from];
                str[from] = s2;
            }
        }
    }
}
