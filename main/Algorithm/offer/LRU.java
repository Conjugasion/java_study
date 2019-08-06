package Algorithm.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Lucas
 * @date 2019/8/6 9:23
 * 页面置换算法 最近最少使用
 * 几次缺页中断
 */
public class LRU {
    public static void main(String[] args) {
        int[] page = {1, 2, 3, 1, 4, 5, 4, 1, 2};
        // 1 2 3         3
        // 1 2 3         3
        // 1 4 3         4
        // 1 4 5         5
        // 1 4 5         5
        // 1 4 5         5
        // 1 4 2         6
        System.out.println("缺页中断次数：" + pageBreak(page, 3));
    }

    static int pageBreak(int[] page, int n){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < page.length; i++) {
            if (q.contains(page[i])) {
                q.remove(page[i]);
                q.offer(page[i]);
            }else {
                if (q.size()<n){
                    q.offer(page[i]);
                }else {
                    q.poll();
                    q.offer(page[i]);
                }
                count++;
            }
        }
        return count;
    }


}
