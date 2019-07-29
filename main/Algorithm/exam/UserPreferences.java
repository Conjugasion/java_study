package algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/6/14 8:57
 * 读取 1 2 3 4 5
 *  for (int i = 0; i < 5; i++) {
 *             a[i] = scanner.nextInt();
 *         }
 */
public class UserPreferences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        // value:[1, 3, 4]
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int prefer = scanner.nextInt();
            if (map.containsKey(prefer)){
                map.get(prefer).add(i);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(prefer, list);
            }
        }
        scanner.nextLine();
        int q = scanner.nextInt();
        scanner.nextLine();
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            int count = 0;
            for (int j = l; j <= r; j++) {
                if (map.get(k).contains(j)){
                    count++;
                }
            }
            result[i] = count;
            scanner.nextLine();
        }
        for (int i : result) {
            System.out.println(i);
        }
    }
}
