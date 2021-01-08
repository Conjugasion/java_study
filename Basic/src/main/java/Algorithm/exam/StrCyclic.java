package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-07-28 15:24
 */
public class StrCyclic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        char lasthead = ' ';
        char lasttail = ' ';
        for(int i=0;i<str.length;i++){
            if (i==0){
                lasthead = str[i].charAt(0);
                lasttail = str[i].charAt(str[i].length()-1);
            }
            if (i!=0){
                char head = str[i].charAt(0);
                char tail = str[i].charAt(str[i].length()-1);
                if (head!=tail){
                    continue;
                }
            }

        }
    }
}
