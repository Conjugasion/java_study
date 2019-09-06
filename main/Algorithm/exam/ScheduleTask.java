package Algorithm.exam;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/9/4 20:23
 */
public class ScheduleTask {
    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int schedule(int m,int[] array) {

        return 1;
    }
    static ArrayList<ArrayList<Integer>> anpai(int m, int[] array){
        ArrayList<ArrayList<Integer>> list = anpai(m - 1, array);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> sub = list.get(i);
            if (sub.size()>1){
                for (int j = 1; j < sub.size()-1; j++) {
                    ArrayList<Integer> first = (ArrayList<Integer>) sub.subList(0, j);
                    ArrayList<Integer> last = (ArrayList<Integer>) sub.subList(j, sub.size());
                    result.add(first);
                    result.add(last);
                }
            }
        }
        return result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int size  = in.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        int res = schedule(m,array);
        System.out.println(String.valueOf(res));
    }
}
