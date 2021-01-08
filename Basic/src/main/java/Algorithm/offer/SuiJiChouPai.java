package Algorithm.offer;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Lucas
 * @date 2019-07-14 15:40
 * 随机抽/洗牌 54张牌
 * random.nextInt(10)  ---  [0, 10)
 *
 */
public class SuiJiChouPai {
    public static void main(String[] args) {
        int[] card = new int[54];
        for (int i = 1; i <= 54; i++) {
            card[i-1] = i;
        }
        //System.out.println(Arrays.toString(card));
        ArrayList<Integer> p1 = new ArrayList<>();
        ArrayList<Integer> p2 = new ArrayList<>();
        ArrayList<Integer> p3 = new ArrayList<>();
        randomTake(card, p1, p2, p3);
        System.out.println("p1: " + p1 + "size: " + p1.size());
        System.out.println("p2: " + p2 + "size: " + p2.size());
        System.out.println("p3: " + p3 + "size: " + p3.size());
    }

    // 随机抽牌
    static void randomTake(int[] card, ArrayList<Integer> p1,ArrayList<Integer> p2,ArrayList<Integer> p3){
        Random random = new Random();
        for (int i = 0; i < card.length; i++) {
            int x = random.nextInt(card.length-i);
            if (i%3==0){
                p1.add(card[x]);
            }
            else if (i%3==1){
                p2.add(card[x]);
            }
            else {
                p3.add(card[x]);
            }
            int temp = card[card.length-i-1];
            card[card.length-i-1] = card[x];
            card[x] = temp;
        }
    }

    // 随机洗牌
    static void randomWash(int[] card){
        Random random = new Random();
    }
}
