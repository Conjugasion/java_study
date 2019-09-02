package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-08-30 20:00
 */
public class BoyAndGirl {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String users, int k) {
        char[] person = users.toCharArray();
        ArrayList<Integer> boyIndex = new ArrayList<>();
        for (int i = 0; i < person.length; i++) {
            if (person[i]=='b') boyIndex.add(i);
        }

        boolean notFindOne = true;
        int happy1 = -1;
        int happy2 = -1;
        for (int i:boyIndex) {
            int count = 0;
            if (i-1>=0){
                if (person[i-1]=='g') count++;
            }
            if (i+1<person.length){
                if (person[i+1]=='g') count++;
            }
            if (notFindOne&&count==1){
                happy1 = i;
                notFindOne = false;
            }
            if (count==2) {
                happy2 = i;
                break;
            }
        }
        int happy = 0;
        if (happy2!=-1){
            happy = happy2;
        }else happy = happy1;

        int max = 0;
        for (int i:boyIndex) {
            int num = 1;
            int nowK = 0;
            int next = i+1;
            if (next>=person.length){
                next = next % person.length;
            }
            while (nowK<=k&&next!=i){
                if (person[next]=='b'){
                    num++;
                }else {
                    nowK++;
                }
                next = next+1;
                if (next>=person.length){
                    next = next % person.length;
                }
            }
            max = max >= num ? max : num;
        }
        return happy + " " + max;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int k = Integer.valueOf(in.nextLine());

        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}
