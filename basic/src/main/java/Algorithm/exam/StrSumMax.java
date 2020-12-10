package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-21 20:31
 */
public class StrSumMax {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] array = new int[n];
        int sum = 0;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            if(array[i]<0) {
                flag = false;
            }
        }
        sc.nextLine();
        for(int i:array){
            sum+=i;
        }
        if(flag){
            System.out.println(sum);
        }else{
            System.out.println("最小子序列=" + find(array));
            System.out.println("sum=" + sum);
            System.out.println(sum-find(array));
        }
    }

    // 找最小子序列的和
    /*
    暴力搜索
     */
    static int find(int[] array){
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                int current = 0;
                for (int k = i; k <= j; k++) {
                    current += array[k];
                }
                min = current < min ? current : min;
            }
        }
        return min;
    }
}
