package algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 14:13
 * 二维数组
 * 1 2 8 9
 * 2 4 9 12
 * 4 7 10 13
 * 6 8 11 15
 * 左下角
 */
public class problem1 {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(array.length);
//        System.out.println(Arrays.toString(array[1]));
        System.out.println(find(7, array));
        System.out.println(find1(7, array));
    }
    static boolean find(int target, int[][] array){
        int ylen = array.length - 1;
        int xlen = array[0].length;
        int i = 0;
        while (ylen >= 0 && i <= xlen){
            if (array[ylen][i] < target){
                i++;
            }
            else if (array[ylen][i] > target){
                ylen--;
            }
            else return true;
        }
        return false;
    }

    static boolean find1(int target, int[][] array){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list.contains(target);
    }
}
