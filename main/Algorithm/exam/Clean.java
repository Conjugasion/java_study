package Algorithm.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019-09-07 19:32
 */
public class Clean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();
        char[][] matrix = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        int[] x = {sc.nextInt(), sc.nextInt()};
        int[] y = {sc.nextInt(), sc.nextInt()};
        /*System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));*/
        System.out.println(clean(matrix, x, y));
    }

    static int clean(char[][] matrix, int[] x, int[] y){
        char a = matrix[x[0]][x[1]];
        char b = matrix[y[0]][y[1]];
        matrix[x[0]][x[1]] = b;
        matrix[y[0]][y[1]] = a;
        int[][] mark = new int[matrix.length][matrix[x[0]].length];
        int up1 = check(matrix, x, "up", mark);
        int level1 = check(matrix, x, "level", mark);
        int up2 = check(matrix, y, "up", mark);
        int level2 = check(matrix, y, "level", mark);
        return up1+level1+up2+level2;
    }

    static int check(char[][] matrix, int[] point, String where, int[][] mark){
        char letter = matrix[point[0]][point[1]];
        int count1 = 0;
        if(mark[point[0]][point[1]] == 0) {
            count1++;
        }

        if (where.equals("up")){
            int temp = count1;
            for (int i = point[0]-1; i >=0; i--) {
                if (matrix[i][point[1]]!=letter||mark[i][point[1]]==1) break;
                count1++;
                mark[i][point[1]] = 1;
            }
            if (count1<3){
                count1 = temp;
                mark = new int[matrix.length][matrix[point[0]].length];;
            }
            for (int i = point[0]+1; i < matrix.length; i++) {
                if (matrix[i][point[1]]!=letter||mark[i][point[1]]==1) break;
                count1++;
                mark[i][point[1]] = 1;
            }
            if (count1<3){
                count1 = 0;
                mark = new int[matrix.length][matrix[point[0]].length];;
            }
        }else {
            int temp = count1;
            for (int i = point[1]-1; i >=0; i--) {
                if (matrix[point[0]][i]!=letter||mark[point[0]][i]==1) break;
                count1++;
                mark[point[0]][i] = 1;
            }
            if (count1<3){
                count1 = temp;
                mark = new int[matrix.length][matrix[point[0]].length];;
            }
            for (int i = point[1]+1; i < matrix[point[0]].length; i++) {
                if (matrix[point[0]][i]!=letter||mark[point[0]][i]==1) break;
                count1++;
                mark[point[0]][i] = 1;
            }
            if (count1<3){
                count1 = 0;
                mark = new int[matrix.length][matrix[point[0]].length];;
            }
        }
        return count1;
    }
}
