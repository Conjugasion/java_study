package Algorithm.offer;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-06-25 21:08
 *递归练习
 */
public class DiGui {
    public static void main(String[] args) {
        System.out.println("阶乘: " + jiecheng(5));
        hannuota(3, "A", "C", "B");
        int[] array = new int[]{1,4,5,2,0,6,-1};
        System.out.println(seekMax(array, 0, array.length-1));
        bubbleSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    // 阶乘
    static int jiecheng(int i){
        if (i==0){
            return 1;
        }
        return i * jiecheng(i-1);
    }

    // 汉诺塔
    // from a, to c, other b
    // 已经知道怎么把n-1个圆盘从A移动到C，现在要把n个圆盘从A移动到C，
    // 首先把n-1个圆盘按照之前的方法从A移动到B，然后把第n个盘子放到c，然后再按照之前的方法将n-1个盘子从b移到c
    static void hannuota(int n, String from, String to, String other){
        if (n==1){
            System.out.println(from + "->" + to);
            return;
        }
        hannuota(n-1, from, other, to);
        hannuota(1, from, to, other);
        hannuota(n-1, other, to, from);
    }

    // 寻找数组最大值
    static int seekMax(int[] array, int start, int end){
        if (start == end) return array[start];
        return array[end] >= seekMax(array, start, end-1) ? array[end] : seekMax(array, start, end-1);
    }

    // 冒泡排序递归版
    static void bubbleSort(int[] array, int start, int end){
        if (end <= start) return;
        bubbleSort(array, start, end-1);  // 假设已经排好了start~end-1
        for (int i = end-1; i >= start; i--) {
            if (array[i] > array[i+1]){
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
            else break;
        }
    }
}
