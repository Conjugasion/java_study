package Algorithm.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-01 16:18
 */
public class Card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 1; i <= 3; i++) {
            map.put(i, new int[]{sc.nextInt(), sc.nextInt()});
        }
        /*for (int key:map.keySet()) {
            System.out.println(Arrays.toString(map.get(key)));
        }*/
        HashMap<Integer, String[]> result = new HashMap<>();
        for (int key:map.keySet()){
            int[] ele = map.get(key);
            int mei = ele[0];
            int bai = ele[1];
            if (!iscontain(mei, bai)){
                result.put(key, null);
            }else {
                String method = "";
                String method2 = "";

                String meistr = String.valueOf(mei);
                String baistr = String.valueOf(bai);
                char[] meichar = meistr.toCharArray();
                char[] baichar = baistr.toCharArray();

                char first;
                int index = 0;
                for (char m:meichar) {
                    if (containChar(m, baistr)){
                        first = m;
                        break;
                    }
                    index++;
                }
                for (int i = 0; i < meichar.length; i++) {
                    if (!containChar(meichar[i], baistr)){
                        method += "d";
                        method2 += "d";
                    }else {
                        if (i<index){
                            method += 'l';
                            method2 += 'l';
                        }else if (i==index){
                            method += "l";
                            method2 += "r";
                        }else {
                            method += "r";
                            method2 += "r";
                        }
                    }
                }
                result.put(key, new String[]{method, method2});
            }
        }
        for (int key:result.keySet()) {
            if (result.get(key)!=null){
                System.out.println("{");
                for (String ss:result.get(key)) {
                    System.out.println(ss);
                }
                System.out.println("}");
            }else {
                System.out.println("{");
                System.out.println("}");
            }

        }
    }
    static int arrindex(char[] chars, char c){
        int index = 0;
        for (char cc:chars) {
            if (cc==c) return index;
            else index++;
        }
        return index;
    }

    static boolean containChar(char c, String str){
        char[] chars = str.toCharArray();
        for (char cc:chars) {
            if (cc==c) return true;
        }
        return false;
    }

    static boolean iscontain(int mei, int bai){
        ArrayList<Integer> meil = new ArrayList<>();
        ArrayList<Integer> bail = new ArrayList<>();
        while (true){
            int mod = mei%10;
            meil.add(mod);
            mei = mei/10;
            if (mei==0) break;
        }
        while (true){
            int mod = bai%10;
            bail.add(mod);
            bai = bai/10;
            if (bai==0) break;
        }
        for (int i:bail) {
            if (!meil.contains(i)) return false;
        }
        return true;
    }
}
