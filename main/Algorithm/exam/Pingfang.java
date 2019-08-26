package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/19 20:52
 */
public class Pingfang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(sc.nextInt());
        }
        ArrayList<String[]> all = new ArrayList<>();
        pailie(arr, 0, arr.length-1, all);
        int count = 0;
        for (String[] ss:all) {
            /*System.out.println(Arrays.toString(ss));*/
            boolean flag = true;
            for (int i = 0; i < ss.length-1; i++) {
                int num1 = Integer.valueOf(ss[i]);
                int num2 = Integer.valueOf(ss[i+1]);

                int a = (int)Math.sqrt(num1+num2);          // 判断一个数是不是完全平方数
                if (a*a!=(num1+num2)){
                    flag = false;
                }

            }
            if (flag) count++;
        }
        System.out.println(count);
    }

    static void pailie(String[] str, int from, int to, ArrayList<String[]> all){
        if (from == to) {
            all.add(Arrays.copyOfRange(str, 0, str.length));
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
