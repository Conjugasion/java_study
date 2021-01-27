import java.util.Random;

/**
 * @author tangdongfan
 * @date 2021/1/26 16:58
 * @description 快速排序Java版
 */

public class FastSortJava {

    public static void main(String[] args) {
        int arrayNum = 100000000;
        Random r = new Random(100);
        int[] array = r.ints(arrayNum).toArray();
        long start = System.currentTimeMillis();
        location(array, 0, arrayNum-1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时: " + (end-start));
    }

    public static void location(int[] array, int left, int right){
        if (left < right){
            int i = right;
            int j = left;
            int pivot = array[left];
            while (i != j){
                while (array[i] >= pivot && i > j) {
                    i--;
                }
                while (array[j] <= pivot && i > j){
                    j++;
                }
                if (i > j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            array[left] = array[i];
            array[i] = pivot;

            location(array, left, i-1);
            location(array, i+1, right);
        }
    }
}
