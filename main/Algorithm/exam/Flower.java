package Algorithm.exam;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 21:15
 */
public class Flower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= t; i++) {
            map.put(i, new int[]{sc.nextInt(), sc.nextInt()});
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i:map.keySet()) {
            int start = map.get(i)[0];
            int end = map.get(i)[1];
            BigInteger sum = new BigInteger("0");
            for (int j = start; j <= end; j++) {
                sum = sum.add(method(j, k));
            }
            System.out.println(sum.mod(new BigInteger("1000000007")));
        }

    }

    static BigInteger method(int number, int k){
        ArrayList<String> poss = new ArrayList<>();
        int bieshu = number/k;
        BigInteger count = new BigInteger("1");
        if (bieshu==0){
            return count;
        }else {
            for (int i = 1; i <= bieshu; i++) {
                count = count.add(new BigInteger(String.valueOf(number - k*i + 1)));
            }
        }
        return count;
    }
}
