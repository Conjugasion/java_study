package Algorithm.exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/23 18:54
 */
public class Djstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] one = new int[6];
        int[] two = new int[6];
        int[] three = new int[6];
        int[] four = new int[6];
        int[] five = new int[6];
        int[] six = new int[6];
        for (int i = 0; i < 6; i++) {
            one[i] = sc.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            two[i] = sc.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            three[i] = sc.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            four[i] = sc.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            five[i] = sc.nextInt();
        }
        for (int i = 0; i < 6; i++) {
            six[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> fromOne = new HashMap<>();
        HashMap<Integer, Integer> fromTwo = new HashMap<>();
        HashMap<Integer, Integer> fromThree = new HashMap<>();
        HashMap<Integer, Integer> fromFour = new HashMap<>();
        HashMap<Integer, Integer> fromFive = new HashMap<>();
        HashMap<Integer, Integer> fromSix = new HashMap<>();

        for (int i = 0; i < 6; i++) {
            if (one[i]!=0&&one[i]!=-1){
                fromOne.put(i+1, one[i]);    // 从1直接能到的地方
            }
        }

        for (int i = 0; i < 6; i++) {
            if (two[i]!=0&&two[i]!=-1){
                fromTwo.put(i+1, two[i]);    // 从2直接能到的地方
            }
        }
        for (int i = 0; i < 6; i++) {
            if (three[i]!=0&&three[i]!=-1){
                fromThree.put(i+1, three[i]);    // 从3直接能到的地方
            }
        }
        for (int i = 0; i < 6; i++) {
            if (four[i]!=0&&four[i]!=-1){
                fromFour.put(i+1, four[i]);    // 从4直接能到的地方
            }
        }
        for (int i = 0; i < 6; i++) {
            if (five[i]!=0&&five[i]!=-1){
                fromFive.put(i+1, five[i]);    // 从5直接能到的地方
            }
        }
        for (int i = 0; i < 6; i++) {
            if (six[i]!=0&&six[i]!=-1){
                fromSix.put(i+1, six[i]);    // 从6直接能到的地方
            }
        }

        for (int j = 0; j < 2; j++) {
            if (fromOne.containsKey(2)){
                for (int i:fromTwo.keySet()) {
                    int now  = fromOne.get(2)+fromTwo.get(i);
                    if (fromOne.containsKey(i)){
                        int old = fromOne.get(i);
                        if (now<old) fromOne.put(i, now);
                    }else {
                        fromOne.put(i, now);
                    }
                }
            }
            if (fromOne.containsKey(3)){
                for (int i:fromThree.keySet()) {
                    int now  = fromOne.get(3)+fromThree.get(i);
                    if (fromOne.containsKey(i)){
                        int old = fromOne.get(i);
                        if (now<old) fromOne.put(i, now);
                    }else {
                        fromOne.put(i, now);
                    }
                }
            }
            if (fromOne.containsKey(4)){
                for (int i:fromFour.keySet()) {
                    int now  = fromOne.get(4)+fromFour.get(i);
                    if (fromOne.containsKey(i)){
                        int old = fromOne.get(i);
                        if (now<old) fromOne.put(i, now);
                    }else {
                        fromOne.put(i, now);
                    }
                }
            }
            if (fromOne.containsKey(5)){
                for (int i:fromFive.keySet()) {
                    int now  = fromOne.get(5)+fromFive.get(i);
                    if (fromOne.containsKey(i)){
                        int old = fromOne.get(i);
                        if (now<old) fromOne.put(i, now);
                    }else {
                        fromOne.put(i, now);
                    }
                }
            }
            if (fromOne.containsKey(6)){
                for (int i:fromSix.keySet()) {
                    int now  = fromOne.get(6)+fromSix.get(i);
                    if (fromOne.containsKey(i)){
                        int old = fromOne.get(i);
                        if (now<old) fromOne.put(i, now);
                    }else {
                        fromOne.put(i, now);
                    }
                }
            }
        }
        for (int i:fromOne.keySet()) {
            System.out.println(fromOne.get(i));
        }
    }
}
