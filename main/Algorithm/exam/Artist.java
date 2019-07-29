package algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/6/14 15:57
 */
public class Artist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        ArrayList<ArrayList<Integer>> chain = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            ArrayList<Integer> color = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                color.add(scanner.nextInt());
            }
            chain.add(color);
            scanner.nextLine();
        }

        if (m==1){
            System.out.println(0);
        }
        else {
            if (m==n){
                Map<Integer, Integer> colorAndCount = new HashMap<>();
                for (ArrayList<Integer> a:chain) {
                    for (int i: a){
                        if (colorAndCount.containsKey(i)){
                            colorAndCount.put(i, colorAndCount.get(i)+1);
                        }
                        else {
                            colorAndCount.put(i,1);
                        }
                    }
                }
                System.out.println(stat(colorAndCount));
            }
            else {
                Map<Integer, Integer> colorAndCount = new HashMap<>();
                HashSet<Integer> result;
                // 统计第一组m [0, m-1]
                for (int i = 0; i < m; i++) {
                    ArrayList<Integer> colors = chain.get(i);
                    for (int j : colors) {
                        if (colorAndCount.containsKey(j)){
                            colorAndCount.put(j, colorAndCount.get(j)+1);
                        }
                        else {
                            colorAndCount.put(j,1);
                        }
                    }
                }
                result = stat(colorAndCount);
                for (int i = 1; i < n; i++) {
                    ArrayList<Integer> lastColors = chain.get(i-1);
                    for (int j: lastColors) {
                        colorAndCount.put(j, colorAndCount.get(j)-1);
                    }
                    ArrayList<Integer> nextColors = chain.get((m+i-1)%n);
                    for (int j : nextColors) {
                        if (colorAndCount.containsKey(j)){
                            colorAndCount.put(j, colorAndCount.get(j)+1);
                        }
                        else {
                            colorAndCount.put(j,1);
                        }
                    }
                    result.addAll(stat(colorAndCount));
                }
                System.out.println(result.size());
            }
        }
    }

    // 统计不符需求的颜色
    public static HashSet<Integer> stat(Map<Integer, Integer> map){
        HashSet<Integer> list = new HashSet<>();
        for (int i : map.keySet()) {
            if (map.get(i) >= 2){
                list.add(i);
            }
        }
        return list;
    }
}
