package Algorithm.offer;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/8/8 17:38
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 0 之前，你需要完成课程 1。所以这是可能的。
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 0 之前，你需要先完成​课程 1；并且学习课程 1 之前，你还应先完成课程 0。这是不可能的。
 *
 * 拓扑排序, 将没有前驱的节点剔除，若最后集合中没有节点说明true，剔除不掉了说明有环false
 */
public class Prerequisites {
    public static void main(String[] args) {
        System.out.println(canFinish(3, new int[][]{{1,0},{1,2},{0,1}}));
    }

    static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> outin = new HashMap<>();     // 前驱 : 后驱
        for(int[] i:prerequisites){
            if (!outin.containsKey(i[0])){
                outin.put(i[0], new ArrayList<Integer>(){{add(i[1]);}});
            }else {
                outin.get(i[0]).add(i[1]);
            }
        }
        System.out.println(outin);

        while (true){
            Set<Integer> head = outin.keySet();      // 所有前驱
            int preSize = head.size();                              // 未删除前的数量
            if (head.size()==0) {
                return true;
            }

            HashSet<Integer> rears = new HashSet<>();                // 所有后驱, 去重
            for (int i: head) {
                ArrayList<Integer> rear = outin.get(i);
                rears.addAll(rear);
            }

            for (int h:head) {
                if (!rears.contains(h)){
                    outin.remove(h);
                }
            }

            int postSize = outin.keySet().size();                   // 删除后的数量
            if (preSize==postSize) return false;
        }
    }
}
