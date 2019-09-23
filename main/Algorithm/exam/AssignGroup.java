package Algorithm.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/20 20:49
 */
public class AssignGroup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            ArrayList<Integer> fight = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                fight.add(sc.nextInt());
            }
            Collections.sort(fight);
            assign(fight, result);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(result.get(2*i) + " " + result.get(2*i+1));
        }
    }

    static void assign(ArrayList<Integer> fight, ArrayList<Integer> result){
        int size = fight.size();
        if (size==3){
            int v0 = fight.get(0);
            int v1 = fight.get(1);
            int v2 = fight.get(2);
            if (v0+v1<=v2) {
                result.add(v0+v1);
                result.add(v2);
            }else {
                result.add(v2);
                result.add(v0+v1);
            }
        }else{
            int i = 0;
            int j = size-1;
            int fight1 = 0;
            int fight2 = 0;
            if (size%2==0){
                if (size/2%2==0){
                    boolean flag = true;
                    while (i<j){
                        if (flag) {
                            fight1 += fight.get(i)+fight.get(j);
                            i++;j--;
                            flag = false;
                        }else {
                            fight2 += fight.get(i)+fight.get(j);
                            i++;j--;
                            flag = true;
                        }
                    }
                    if (fight1<=fight2) {
                        result.add(fight1);
                        result.add(fight2);
                    }
                    else {
                        result.add(fight2);
                        result.add(fight1);
                    }

                }else {
                    boolean flag = true;
                    while (j-i>2){
                        if (flag) {
                            fight1 += fight.get(i)+fight.get(j);
                            i++;j--;
                            flag = false;
                        }else {
                            fight2 += fight.get(i)+fight.get(j);
                            i++;j--;
                            flag = true;
                        }
                    }
                    if (fight1<=fight2) {
                        fight1 += fight.get(j);
                        fight2 += fight.get(i);
                    }
                    else {
                        fight1 += fight.get(i);
                        fight2 += fight.get(j);
                    }

                    if (fight1<=fight2) {
                        result.add(fight1);
                        result.add(fight2);
                    }
                    else {
                        result.add(fight2);
                        result.add(fight1);
                    }
                }
            }else {
                boolean flag = true;
                while (i<j){
                    if (flag) {
                        fight1 += fight.get(i)+fight.get(j);
                        i++;j--;
                        flag = false;
                    }else {
                        fight2 += fight.get(i)+fight.get(j);
                        i++;j--;
                        flag = true;
                    }
                }

                if (fight1<=fight2) fight1 += fight.get(size/2);
                else fight2 += fight.get(size/2);

                if (fight1<=fight2) {
                    result.add(fight1);
                    result.add(fight2);
                }
                else {
                    result.add(fight2);
                    result.add(fight1);
                }
            }

        }
    }
}
