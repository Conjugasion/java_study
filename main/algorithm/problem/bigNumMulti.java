package algorithm.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @auther Lucas
 * @date 2019/2/22 21:28
 */
public class bigNumMulti {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[] s = br.readLine().split(" ");
        String num1 = s[0];
        String num2 = s[1];
        String[] str1 = num1.split("");
        String[] str2 = num2.split("");
        int n = str1.length + str2.length -1;

        ArrayList<ArrayList> all = new ArrayList<>();
        for(int i=0; i < str1.length; i++){
            ArrayList<Integer> part = new ArrayList<>();
            for(int k =0; k<n; k++){
                part.add(0);
            }
            for(int j=0, l=i; j < str2.length && l < i + str2.length; j++, l++){
                {
                    part.set(l,Integer.valueOf(str1[i])*Integer.valueOf(str2[j]));
                }
            }
            all.add(part);
        }
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i=0; i < all.get(0).size(); i++){
            int number = 0;
            for (ArrayList arrayList : all) {
                number += (Integer) arrayList.get(i);
            }
            sum.add(number);
        }

        for (int i= sum.size()- 1; i >=0 ; i--){
            if (i !=0){
                int up = sum.get(i)/10;
                sum.set(i,sum.get(i)%10);
                sum.set(i-1,sum.get(i-1) + up);
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i : sum){
            result.append(i);
        }
        System.out.println(result);
    }
}
