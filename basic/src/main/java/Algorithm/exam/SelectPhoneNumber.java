package Algorithm.exam;


import java.util.*;

/**
 * @author Lucas
 * @date 2019/7/27 12:07
 */
/*
A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？

输入描述:
第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
数据范围：
2 <= K <= N <= 10000

输出描述:
第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。

输入例子1:
6 5
787585

输出例子1:
4
777577

例子说明1:
花费为4的方案有两种：777577与777775，前者字典序更小。
*/
public class SelectPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] phoneNumber = new int[n];
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < chars.length; i++) {
            int num = chars[i]-48;
            phoneNumber[i] = num;
            min = min <= num ? min : num;
            max = max >= num ? max : num;
        }
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        //System.out.println(Arrays.toString(phoneNumber));  // [7, 8, 7, 5, 8, 5]
        int minCost = Integer.MAX_VALUE;
        String coolNum = null;
        for (int i = min; i <= max; i++) {    // 选择k位i的靓号
            StringBuilder number = new StringBuilder();
            int count = k;
            int cost = 0;
            int[] newNumber = Arrays.copyOfRange(phoneNumber, 0, phoneNumber.length);
            for (int j = 0; j <= max-min; j++) {    // 代价从0~max-min
                if (count==0) break;
                for (int l = 0; l < n; l++) {       // 遍历数组0~n位
                    if (count!=0&&newNumber[l]-i==j){     // ，从起首到末尾，优先将大的变成小的
                        count--;
                        cost+=j;
                        newNumber[l] = i;
                    }
                }if (j!=0){
                    for (int l = n-1; l >=0 ; l--) {
                        if (count!=0&&newNumber[l]-i==-j){    // 从末尾到起首，其次将小的变成大的
                            count--;
                            cost+=j;
                            newNumber[l] = i;
                        }
                    }
                }
                if (cost<minCost){
                    minCost=cost;
                    for (int num:newNumber) {
                        number.append(num);
                    }
                    coolNum = number.toString();
                }
            }
        }
        System.out.println(minCost);
        System.out.println(coolNum);
    }
}
