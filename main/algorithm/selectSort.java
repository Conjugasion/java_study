package algorithm;

import java.util.Arrays;

/**
 * @auther Lucas
 * @date 2019/2/20 16:35
 */
public class selectSort {
    public static void main(String[] args) {
        int[] a = {2,5,1,6,4,7,1};
        f1(a);
    }

    static void f1(int[] a){
        int min;
        int b;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]){
                    min = j;
                }
            }
            b = a[i];
            a[i] = a [min];
            a[min] = b;
        }
        Arrays.asList(a).forEach((i) -> System.out.println(i));
    }
}
