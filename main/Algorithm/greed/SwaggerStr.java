package Algorithm.greed;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Lucas
 * @date 2019-08-02 15:31
 * 摇摆序列
 * 一个整数序列，如果两个相邻元素的差恰好正负(负正)交替出现，则被称为摇摆序列
 * 例如1，7，4，9，2，5，相邻的元素差为6，-3，5，-7，3，是摇摆序列
 * 一个小于2个元素的序列一定是摇摆序列，两个元素的序列，只要两个元素不相等，也一定是摇摆序列
 * 给定一个随机序列，求这个序列满足摇摆规律的最长子序列长度。
 */
public class SwaggerStr {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i <= 10; i++) {
            int[] str = new int[i];
            for (int j = 0; j < i; j++) {
                str[j] = random.nextInt(i);
            }
            System.out.println(Arrays.toString(str));
            System.out.println("动态规划法de最长摇摆子序列：" + dynamic(str));
            System.out.println("贪心法de最长摇摆子序列：" + find(str));
            System.out.println("使用状态机de贪心法de最长摇摆子序列：" + findState(str));
            System.out.println("--------------——---");
        }
    }

    // dp[i]表示以第i个数字结尾的 满足摇摆规律的 最长子序列
    // dp[i] = max(dp[0], dp[1],...,dp[i-1])+1, 如果 差[i]*差[0]/差[1]/.../差[i-1] < 0;
    static int dynamic(int[] str){
        if (str.length==0||str.length==1) return str.length;
        int [] diff = new int[str.length-1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = str[i+1] - str[i];   // 0,1,-1,2,-3
        }
        // 用于记录最大结果值
        int result = 0;
        // 初始化dp数组
        int[] dp = new int[diff.length];
        // 以index=0结尾的序列必然是摇摆序列，因为只有一个元素。。
        dp[0] = diff[0] == 0 ? 0 : 1;
        for (int i = 1; i < diff.length; i++) {
            int max = 0;
            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if (diff[i]*diff[j]<0){
                    max = max >= dp[j] ? max : dp[j];
                    flag = true;
                }
            }
            if (flag) dp[i] = max + 1;
            else dp[i] = max;
            result = result >= dp[i] ? result : dp[i];
        }
        return result+1;
    }

    // 贪心法
    // 选择递增、递减的转折点形成摇摆子序列！
    static int find(int[] str){
        if (str.length==0||str.length==1) return str.length;
        int length = 1;
        int flag = 1;      // 增减标志位，1表示递增，-1表示递减, 0表示不变
        for (int i = 0; i < str.length-1; i++) {
            if (i==0){
                if (str[0] < str[1]) {
                    flag = 1;
                    length++;
                } else if (str[0] > str[1]) {
                    flag = -1;
                    length++;
                } else {
                    flag=0;
                }
            }else{
                if (str[i] > str[i+1] && flag == 1) {
                    flag = -1;
                    length++;
                } else if (str[i] < str[i+1] && flag == -1) {
                    flag = 1;
                    length++;
                } else if(str[i] < str[i+1] && flag == 0) {
                    flag = 1;
                    length++;
                } else if(str[i] > str[i+1] && flag == 0) {
                    flag = -1;
                    length++;
                }
            }
        }
        return length;
    }

    // 贪心法
    // 状态机
    //     begin
    //
    // up        down
    static int findState(int[] str){
        if (str.length==0) return str.length;
        final int begin = 0;
        final int up = 1;
        final int down = 2;
        int state = begin;  // 初始状态为begin
        int length = 1;     // 长度至少为1

        for (int i = 0; i < str.length-1; i++) {
            switch (state){
                case begin:
                    if (str[i] == str[i+1]){
                        state = begin;
                    }else if (str[i] > str[i+1]){
                        state = down;
                        length++;
                    }else {
                        state = up;
                        length++;
                    }
                    break;
                case up:
                    if (str[i] <= str[i+1]){   // 碰到相等情况，不改变状态，length不++
                        state = up;
                    }else {
                        state = down;
                        length++;
                    }
                    break;
                case down:
                    if (str[i] >= str[i+1]){
                        state = down;
                    }else {
                        state = up;
                        length++;
                    }
                    break;
            }
        }
        return length;
    }
}
