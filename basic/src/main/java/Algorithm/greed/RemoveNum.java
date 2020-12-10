package Algorithm.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author Lucas
 * @date 2019-08-02 17:26
 * 已知一个使用字符串表示的非负整数num，将num中的k个数字移除，求移除k个数字后，可能获得的最小数字
 * 1432219 k=3，去掉4，3，2得到的1219最小！
 */
public class RemoveNum {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 1; i < 11; i++) {
            int k = random.nextInt(i);
            String str = String.valueOf(10023);
            System.out.println("k=" + k);
            System.out.println("使用栈de方法：" + findByStack(str, k));
            System.out.println("使用k次循环de方法：" + find(str, k));
            System.out.println("-----------");
        }
    }

    // k次循环，比较暴力
    static String find(String str, int k){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        for (int j = 0; j < k; j++) {
            ArrayList<Character> temp = new ArrayList<>(list);
            for (int i = 0; i < temp.size()-1; i++) {   // 从高位向低位遍历
                if (temp.get(i) > temp.get(i+1) && i!=0 && temp.get(i+1) != 0){       // 如果对应数字大于下一位数字，移除该位数字，否则保留该位
                    temp.remove(i);
                    break;                              // 跳出循环，对新数字重复操作
                }
            }
            list = temp;
        }
        while(list.size()!=0 && k > 0){
            list.remove(list.size()-1);
            k--;
        }
        if (list.size()==0) return "0";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c:list) {
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

    }

    // 使用栈的思想
    static String findByStack(String str, int k){
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            while (stack.size()!=0 && stack.peek() > str.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            if (stack.size()!=0 || str.charAt(i)!='0')     // 首位不能为零
            stack.push(str.charAt(i));
        }
        while(stack.size()!=0 && k > 0){        // 12345 k=3，k没用完
            stack.pop();
            k--;
        }
        if (stack.size()==0) return "0";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c:stack) {
                stringBuilder.append(c);
            }
            return stringBuilder.toString();
        }

    }
}
