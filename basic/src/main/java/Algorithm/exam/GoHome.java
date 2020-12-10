package Algorithm.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/17 19:53
 */
public class GoHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<HashMap<Integer, ArrayList<Integer>>> lists = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            boolean find = false;
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                int p1 = sc.nextInt();
                int p2 = sc.nextInt();
                if (map.containsKey(p1)){
                    map.get(p1).add(p2);
                }else {
                    map.put(p1, new ArrayList<Integer>(){{add(p2);}});
                }
            }
            if (map.containsKey(1)){
                ArrayList<Integer> fromOne = map.get(1);
                for (int two:fromOne) {
                    if (two==n) {
                        find = true;
                        break;
                    }
                    else {
                        if (find) break;
                        if (map.containsKey(two)) {
                            ArrayList<Integer> fromTwo = map.get(two);
                            for (int three:fromTwo) {
                                if (three==n) {
                                    find = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (find) System.out.println("POSSIBLE");
            else System.out.println("IMPOSSIBLE");
        }
    }
}
