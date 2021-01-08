package Algorithm.exam;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/8/20 14:15
 */
public class OpenLight {
    public static void main(String[] args) {
        int n = 100;
        int[] light = new int[n];
        for (int i = 0; i < n; i++) {
            light[i] = i+1;
        }

        int[] person = new int[n];
        for (int i = 0; i < n; i++) {
            person[i] = i+1;
        }

        boolean[] status = new boolean[n];    // false关 true开

        for (int i = 0; i < n; i++) {       // 人
            for (int j = 0; j < n; j++) {   // 灯
                if (light[j]%person[i]==0){
                    status[j] = !status[j];
                }
            }
        }
        System.out.println(Arrays.toString(status));
        for (int i = 0; i < n; i++) {
            if (status[i]){
                System.out.print(i+1 + " ");
            }
        }
    }
}
