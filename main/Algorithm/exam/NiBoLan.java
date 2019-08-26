package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Lucas
 * @date 2019/8/19 19:41
 * 逆波兰式
 */
public class NiBoLan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        System.out.println(Arrays.toString(ss));

        Stack<String> stack = new Stack<>();
        for (String s:ss) {
            if (s.equals("+")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num1+num2));
            }else if (s.equals("-")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num2-num1));
            }else if (s.equals("*")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num1*num2));
            }else if (s.equals("/")){
                int num1 = Integer.valueOf(stack.pop());
                int num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num2/num1));
            }else {
                stack.push(s);
            }
        }
        System.out.println(stack.peek());

    }
}
