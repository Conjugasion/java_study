package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/20 20:01
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int length = sc.nextInt();// 长度
            sc.nextLine();
            String str = sc.nextLine();// 字符串
            
            if (length<11||!str.contains("8")) result.add("NO");
            else {
                int j = 0;
                while(str.charAt(j)!='8'){
                    j++;
                }
                if (length-j>=11) result.add("YES");
                else result.add("NO");
            }
        }
        for (String s:result) {
            System.out.println(s);
        }
    }
}
