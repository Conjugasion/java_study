package Algorithm.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2020/3/12 19:05
 */
public class DoubleRoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] road = new String[2][n];
        String[] r1 = sc.nextLine().split("");
        String[] r2 = sc.nextLine().split("");
        /*System.out.println(Arrays.toString(r1));*/
        for (int i = 0; i < n; i++) {
            road[0][i] = r1[i];
        }
        for (int i = 0; i < n; i++) {
            road[1][i] = r2[i];
        }

        int[] result = new int[1];
        boolean found = findPath1(road, 0, 0, n, result);
        if (found) {
            System.out.println(result[0]);
        } else System.out.println(-1);


    }

    static boolean findPath1(String[][] road, int i, int j, int n, int[] result){
        if(i==1&&j==n-1) {
            result[0]++;
            return true;
        }

        boolean p1 = false;
        boolean p2 = false;
        boolean p3 = false;
        if (i>=0 && i<=1 && j>=0 && j+1<n && road[i][j+1].equals(".")) {
            p1 = findPath1(road, i, j + 1, n, result);
        }
        if (i>=0 && i<=1 && j>=0 && j+1<n && i-1>=0 && road[i-1][j+1].equals(".")){
            p2 = findPath1(road, i-1, j+1, n, result);
        }
        if (i>=0 && i<=1 && j>=0 && j+1<n && i+1<=1 && road[i+1][j+1].equals(".")){
            p3 = findPath1(road, i+1, j+1, n, result);
        }
        return p1 || p2 || p3;
    }
}
