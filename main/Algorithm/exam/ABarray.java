package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-28 15:04
 */
public class ABarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        String[] s1 = sc.nextLine().split(" ");
        for (int i = 0; i < s1.length; i++) {
            A.add(Integer.valueOf(s1[i]));
        }
        String[] s2 = sc.nextLine().split(" ");
        for (int i = 0; i < s2.length; i++) {
            B.add(Integer.valueOf(s2[i]));
        }
        System.out.println(A);
        System.out.println(B);

        int Aindex = -1;
        int pre = -1;
        int behind = -1;
        for (int i = 0; i < A.size(); i++) {
            if (i==0) {
                if (A.get(0)>=A.get(1)){
                    Aindex = 0;
                    behind = 1;
                }
            }else if (i==A.size()-1){
                if (A.get(i)<=A.get(i-1)){
                    Aindex = A.size()-1;
                    pre = A.size()-2;
                }
            }else if (A.get(i)>=A.get(i+1)||A.get(i)<=A.get(i-1)){
                Aindex=i;
                pre = i-1;
                behind = i+1;
            }
        }
        System.out.println("Aindex: " + Aindex);
        System.out.println("pre: " + pre);
        System.out.println("behind: " + behind);

    }
}
