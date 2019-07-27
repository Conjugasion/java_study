package algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/7/27 12:07
 */
public class SelectPhoneNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] phoneNumber = new int[n];
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            phoneNumber[i] = chars[i]-48;
        }

        System.out.println(Arrays.toString(phoneNumber));  // [7, 8, 7, 5, 8, 5]
        int minCost = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> hasUsed = new HashSet<>();
        for (int i = 0; i < phoneNumber.length; i++) {
            // 当前目标达到靓号值
            int target = phoneNumber[i];
            // 没有尝试过该靓号值时再进行操作
            if (!hasUsed.contains(target)){
                hasUsed.add(target);
                // 删除指定索引
                int[] newArray = delEle(phoneNumber, i);
                // 剩余位置的组合方式
                ArrayList<int[]> compose = compose(newArray, k - 1);   // [值1, 值2, ... 索引1, 索引2, ...]
                int curCost = 0;
                for (int[] c:compose) {
                    for (int j = 0; j < k-1; j++) {
                        if (target>=c[j]){
                            curCost+=(target-c[j]);
                        }else {
                            curCost+=(c[j]-target);
                        }
                    }
                    if (minCost>curCost){
                        result.clear();
                        int[] temp = Arrays.copyOfRange(phoneNumber, 0, phoneNumber.length);
                        for (int j = k-1; j < c.length; j++) {
                            temp[c[j]] = target;
                        }
                        StringBuilder str = new StringBuilder();
                        for (int j = 0; j < temp.length; j++) {
                            str.append(temp[j]);
                        }
                        result.add(Integer.valueOf(str.toString()));
                    }else if (minCost==curCost){
                        int[] temp = Arrays.copyOfRange(phoneNumber, 0, phoneNumber.length);
                        for (int j = k; j < c.length; j++) {
                            temp[c[j]] = target;
                        }
                        StringBuilder str = new StringBuilder();
                        for (int j = 0; j < temp.length; j++) {
                            str.append(temp[j]);
                        }
                        result.add(Integer.valueOf(str.toString()));
                    }
                }
            }
        }
        Collections.sort(result);
        System.out.println(result);

    }
    // 组合公式
    static ArrayList<int[]> compose(int[] array, int m){
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                int[] twoNums = {array[i], array[j], i, j};
                result.add(twoNums);
            }
        }
        return result;
    }

    // 删除数组中的指定元素并返回新数组
    static int[] delEle(int[] array, int index){
        int[] newArray = new int[array.length-1];
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (i==index) continue;
            newArray[n] = array[i];
            n++;
        }
        return newArray;
    }
}
