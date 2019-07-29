package algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/7/26 16:16
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class RobotMatrix {
    public static void main(String[] args) {
        int rows = 10;
        int cols = 10;
        int threshold = 5;
        int[] matrix = new int[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int index = i*cols+j;
                int ii = i;
                int jj = j;
                int num = 0;
                while(ii!=0){
                    num+=(ii%10);
                    ii=ii/10;
                }
                while(jj!=0){
                    num+=(jj%10);
                    jj=jj/10;
                }
                matrix[index] = num;
            }
        }
        System.out.println("matrix: " + Arrays.toString(matrix));
        int[] hasPass = new int[rows*cols];
        findPath(matrix, 0, 0, rows, cols, threshold, 0, hasPass);
        System.out.println("hasPass: " + Arrays.toString(hasPass));
        int count = 0;
        for(int i:hasPass){
            if(i==1) count++;
        }
        System.out.println(count);
    }
    static boolean findPath(int[] matrix, int x, int y, int rows, int cols, int threshold, int k, int[] hasPass){
        int index = x*cols+y;
        if (x<0||y<0||x>=rows||y>=cols||matrix[index]>threshold||hasPass[index]==1) return false;

        hasPass[index] = 1;
        if(findPath(matrix, x-1, y, rows, cols, threshold, k+1, hasPass)||
           findPath(matrix, x+1, y, rows, cols, threshold, k+1, hasPass)||
           findPath(matrix, x, y-1, rows, cols, threshold, k+1, hasPass)||
           findPath(matrix, x, y+1, rows, cols, threshold, k+1, hasPass)
        ){
            return true;
        }
        //不需要清空，只要曾经到过就行
        //hasPass[index] = 0;
        return false;
    }
}
