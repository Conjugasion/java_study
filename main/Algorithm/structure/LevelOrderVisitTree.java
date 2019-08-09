package Algorithm.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Lucas
 * @date 2019/8/9 11:05
 * 给定一个二叉树，返回其按层次遍历的节点值。(即逐层地，从左到右访问所有节点)
 * [[3],[9,20],[15,7]]
 */
public class LevelOrderVisitTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // 逐层遍历二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Object[]> q = new LinkedList<>();     // { 层数, TreeNode }
        q.offer(new Object[]{1, root});

        while (!q.isEmpty()) {
            Object[] node = q.poll();
            if (result.size() < (int)node[0]){
                ArrayList<Integer> level = new ArrayList<>();
                level.add(((TreeNode)node[1]).val);
                result.add(level);
            }else {
                result.get((int)node[0] - 1).add(((TreeNode)node[1]).val);
            }

            if (((TreeNode)node[1]).left != null){
                q.offer(new Object[]{(int)node[0]+1, ((TreeNode)node[1]).left});
            }else if (((TreeNode)node[1]).right != null){
                q.offer(new Object[]{(int)node[0]+1, ((TreeNode)node[1]).right});
            }
        }
        return result;
    }
}
