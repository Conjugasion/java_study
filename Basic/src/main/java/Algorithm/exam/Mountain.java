package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/19 19:53
 */
public class Mountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int cur = find(arr, i);
            max = max >= cur ? max : cur;
        }
        System.out.println(max);
    }

    // 暴力法
    static int find(int[] arr, int index){
        int count = 0;
        boolean up = false;
        boolean down = false;
        for (int i = index; i < arr.length-1; i++) {
            if (i==index){
                if (arr[i]>=arr[i+1]){
                    break;
                }else {
                    up = true;
                    count++;
                }
            }
            if (up&&!down){
                if (arr[i]<arr[i+1]){
                    count++;
                }else if (arr[i]==arr[i+1]){
                    break;
                }else {
                    count++;
                    down = true;
                }
            }else if (up&&down){
                if (arr[i]<=arr[i+1]){
                    break;
                }else {
                    count++;
                }
            }

            /*if (!down){
                if (i==index){
                    if (arr[index]>=arr[index+1]){
                        break;
                    }else {
                        up = true;
                        count++;
                    }

                }else {
                    if (arr[index]<arr[index+1]){
                        count++;
                    }else {
                        count++;
                        down = true;
                    }
                }
            }else {
                if (arr[index]<=arr[index+1]){
                    break;
                }else {
                    count++;
                }
            }*/
        }
        return count;
    }
}
