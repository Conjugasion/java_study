package Algorithm.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/17 20:43
 */
public class Guard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        HashMap<Integer, ArrayList<int[]>> eyes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int[] eye = {start, end};
            if (eyes.containsKey(start)){
                eyes.get(start).add(eye);
            }else eyes.put(start, new ArrayList<int[]>(){{add(eye);}});
        }

        int i = 0;
        int count = 0;
        if (!eyes.containsKey(0)) System.out.print(false);
        else {
            while (true){
                count++;
                ArrayList<int[]> ints = eyes.get(i);
                int[] max = ints.get(0);
                for (int[] ii:ints) {
                    if (max[1] < ii[1] && eyes.containsKey(max[1])){
                        max = ii;
                    }
                }
                i = max[1];
                if (i>=l) {
                    System.out.println(count);
                    break;
                }
            }
        }

    }

    static int find(HashMap<Integer, ArrayList<int[]>> eyes, int i){
        ArrayList<int[]> ints = eyes.get(i);
        int[] max = ints.get(0);
        for (int[] ii:ints) {
            max = max[1] >= ii[1] ? max : ii;
        }
        return 1;
    }
}
