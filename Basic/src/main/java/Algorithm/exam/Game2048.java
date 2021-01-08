package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/11 19:48
 */
public class Game2048 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] input = new String[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }

        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            String[] s = input[i].split(" ");
            int[] inputInt = new int[input.length];
            int index = 0;
            for (int j = 0; j < input.length; j++) {
                if (!s[j].equals("0")){
                    inputInt[index] = Integer.parseInt(s[j]);
                    index++;
                }
            }
            /*
            [2, 4, 0, 0]
            [2, 2, 2, 0]
            [4, 2, 2, 0]
            [8, 8, 2, 2]
             */
            for (int j = 1; j < input.length; j++) {
                if (inputInt[j]==inputInt[j-1]&&inputInt[j]!=0){
                    inputInt[j-1] = inputInt[j]+inputInt[j-1];
                    inputInt[j] = 0;
                }
            }
            int[] result = new int[input.length];
            int index1 = 0;
            for (int j = 0; j < input.length; j++) {
                if (inputInt[j]!=0){
                    result[index1] = inputInt[j];
                    index1++;
                }
            }
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < input.length-1; j++) {
                str.append(result[j]);
                str.append(" ");
            }
            str.append(result[input.length-1]);
            str.append("\n");
            resultStr.append(str);
        }
        System.out.println(resultStr);
    }
}
