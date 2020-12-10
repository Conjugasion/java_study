package Algorithm.exam;

import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/8/19 20:28
 */
public class Money {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int f = sc.nextInt();

        if (n<0){
            System.out.print(0);
        }else if (n==0){
            System.out.print(f);
        }else {
            int[] assist = new int[n+1];
            for (int i = 0; i <= n; i++) {
                assist[i] = -1;
            }
            if (n==1){
                assist[1] = a*f+2-1+32767;
            }else if (n==2){
                assist[1] = a*f+2-1+32767;
                assist[2] = a*assist[1]+b*f+2*4-2+32767;
            }else {
                assist[1] = a*f+2-1+32767;
                assist[2] = a*assist[1]+b*f+2*4-2+32767;
                assist[3] = a*assist[2]+b*assist[1]+c*f+2*9-3+32767;
            }
            int i = cal(n, a, b, c, f, assist);
            System.out.println(a*assist[3]+b*assist[2]+c*assist[1]+2*16-4+32767);
            System.out.print(i);
        }
    }

    static int cal(int n, int a, int b, int c, int f, int[] assist){
        if (n==1){
            return assist[1];
        }
        if (n==2){
            return assist[2];
        }
        if (n==3){
            return assist[3];
        }
        if (assist[n-1]!=-1){
            return assist[n-1];
        }
        if (assist[n-2]!=-1){
            return assist[n-2];
        }
        if (assist[n-3]!=-1){
            return assist[n-3];
        }
        int f1 = cal(n-1, a, b, c, f, assist);
        int f2 = cal(n-2, a, b, c, f, assist);
        int f3 = cal(n-3, a, b, c, f, assist);
        assist[n] = a*f1+b*f2+c*f3+2*((int)Math.pow(n, 2))-n+32767;
        return assist[n];
    }
}
