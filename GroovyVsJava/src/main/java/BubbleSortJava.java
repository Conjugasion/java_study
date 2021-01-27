import java.util.Arrays;
import java.util.Random;

/**
 * @author tangdongfan
 * @date 2021/1/26 17:57
 * @description 冒泡排序Java版
 */

public class BubbleSortJava {

    public static void main(String[] args) {
        int arrayNum = 100000;
        Random r = new Random(100);
        int[] array = r.ints(arrayNum).toArray();
        long start = System.currentTimeMillis();
        for (int i = arrayNum-1; i>0; i--) {
            for (int j =0 ; j < i-1; j++) {
                if (array[j]>array[j+1]){
                    int temp =  array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序耗时: " + (end-start));
    }
}
