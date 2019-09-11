package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/9/11 19:36
 */
public class MinMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //ArrayList<Integer> arr1 = new ArrayList<>();
        int[] arr1 = new int[n];
        for (int i = 0; i <n ; i++) {
            // arr1.add(sc.nextInt());
            arr1[i] = sc.nextInt();
        }
        // ArrayList<Integer> arr2 = new ArrayList<>(arr1);
        int[] arr2 = Arrays.copyOfRange(arr1, 0, arr1.length);
        // 4, 2, 7, 6
        // 2, 4, 6, 7
        // Collections.sort(arr1);
        Arrays.sort(arr1);


        int[] arr3 = new int[arr1.length];
        int index = 0;
        for (int i = arr1.length-1; i >=0; i--) {
            arr3[index] = arr1[i];
            index++;
        }

        // System.out.println(Arrays.toString(arr3));
        int count1 = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i]!=arr3[i]){
                count1++;
            }
        }


        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i]!=arr2[i]){
                count++;
            }
        }
        System.out.println(Math.max(count, count1)/2);
    }
}
