package Algorithm.offer;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lucas
 * @date 2019/8/8 17:38
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 拓扑排序, 将没有前驱的节点剔除，若最后集合中没有节点说明true，剔除不掉了说明有环false
 */
public class Prerequisites {
    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1,0}}));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Integer> outin = new HashMap<>();     // 前驱 : 后驱
        for(int[] i:prerequisites){
            outin.put(i[0], i[1]);
        }

        while (true){
            Set<Integer> head = outin.keySet();                     // 所有前驱
            int preSize = head.size();                              // 未删除前的数量
            if (head.size()==0) {
                return true;
            }
            HashSet<Integer> rear = new HashSet<>(outin.values());  // 所有后驱
            for (int h:head) {
                if (!rear.contains(h)){
                    outin.remove(h);
                }
            }
            int postSize = head.size();                              // 删除后的数量
            if (preSize==postSize) return false;
        }
    }
}
