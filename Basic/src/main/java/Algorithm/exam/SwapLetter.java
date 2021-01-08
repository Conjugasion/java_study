package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/6/14 20:05
 * 使用两次机会可以让索引差在3的两个字母相邻  1和4
 * 使用一次机会可以让索引差在2的两个字母相邻  1和3
 */
public class SwapLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        char[] chars = s[0].toCharArray();
        int m = Integer.valueOf(s[1]);

        // 如果下一个和自己相同，则不交换；换了之后发现下一个和自己相同，则不再交换
        for (int i = 0; i < chars.length-2; i++) {
            for (int j = 0; j < 2; j++) {
                if (chars[i+j] == chars[i+j+1]){
                    break;
                }
                char temp = chars[i+j];
                chars[i+j] = chars[i+j+1];
                chars[i+j+1] = temp;
            }

        }


    }

    // 寻找数组中最长相同元素的长度
    public static int find(char[] chars){
        int count = 1;
        int result = 1;
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] == chars[i+1]){
                count++;
                result = count > result ? count:result;
            }
            else count=1;
        }
        return result;
    }
}
