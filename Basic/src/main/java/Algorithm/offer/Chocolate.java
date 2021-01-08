package Algorithm.offer;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/17 13:41
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，
 * 但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力。
 * 输出一个数表示小Q第一天最多能吃多少块巧克力。
 * 输入例子1:
 * 3 7
 *
 * 输出例子1:
 * 4
 */
public class Chocolate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = m; i >= 1; i--) {
                if (tryEat(0, i, n, m)){
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    // 回溯
    // n表示出差天数，m表示巧克力数量
    // day表示已经吃到第几天了，eat表示当天吃多少
    private static boolean tryEat(int day, int eat, int n, int m){
        if (day==n&&m>=0) return true;
        if (m-eat<0) return false;
        if (eat==1){
            // return tryEat(day+1, 1, n, m-eat);  // 容易栈溢出
            m = m - eat;
            day = n-day-1;
            return m >= day;
        }else {
            return tryEat(day+1, (eat+1)/2, n, m-eat);
        }
    }
}
