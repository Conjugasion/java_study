package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/24 19:53
 */
public class Group {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h1 = new int[n];
        int[] h2 = new int[n];
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            h1[i] = height;
            h2[i] = height;
        }
        Arrays.sort(h2);   // 排序
        /*System.out.println(Arrays.toString(h1));
        System.out.println(Arrays.toString(h2));*/

        ArrayList<Integer> store1 = new ArrayList<>();
        ArrayList<Integer> store2 = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < h1.length; i++) {
            store1.add(h1[i]);
            store2.add(h2[i]);
            for (int j = 0; j < store2.size(); j++) {
                if (store1.contains(store2.get(j))){
                    store1.remove(store2.get(j));
                }
            }
            // store1.removeAll(store2);
            if (store1.size()==0){
                count++;
                store2.clear();
            }
        }
        System.out.println(count);
    }
}
