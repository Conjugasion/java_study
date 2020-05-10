package Algorithm.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2020/3/20 19:29
 */
public class DecreaseBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<Integer, Integer> num = new HashMap<>();
        String[] s = sc.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(s[i]);
            if (num.containsKey(a)){
                num.put(a, num.get(a)+1);
            }else {
                num.put(a, 1);
            }
        }

        int result = 0;
        while (num.size()>1){
            HashMap<Integer, Integer> clone = (HashMap<Integer, Integer>) num.clone();
            for (int key:clone.keySet()) {
                if (clone.get(key)==1){
                    num.remove(key);
                }else {
                    num.put(key, clone.get(key)-1);
                }
            }
            result++;
        }
        if (num.size()==1) System.out.println(++result);
        else System.out.println(result);

    }
}
