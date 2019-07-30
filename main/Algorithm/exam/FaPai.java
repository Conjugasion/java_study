package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019-07-07 16:16
 */
public class FaPai {
    public static void main(String[] args) {
        List<Integer> p1 = new ArrayList<>();
        List<Integer> p2 = new ArrayList<>();
        List<Integer> p3 = new ArrayList<>();
        Set<Integer> card = new HashSet<>();
        for (int i = 1; i < 54; i++) {
            card.add(i);
        }
        Iterator<Integer> it = card.iterator();
        int count = 1;
        while (it.hasNext()){
            if (count <= 18){
                p1.add(it.next());
                count++;
            }
            else if (19 <= count && count <= 36){
                p2.add(it.next());
                count++;
            }
            else {
                p3.add(it.next());
                count++;
            }
        }
        System.out.println(p1.size());
        System.out.println(p2.size());
        System.out.println(p3.size());
        System.out.println(count);
    }
}
