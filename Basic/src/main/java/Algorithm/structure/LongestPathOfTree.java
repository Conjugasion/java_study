package Algorithm.structure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Lucas
 * @date 2019/8/8 15:18
 * 给定一个非空二叉树，返回其最大路径和。
 * 路径指从根节点到叶节点
 */
public class LongestPathOfTree {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }


  }

    public static void main(String[] args) {
        // 筛选路径
    }

    // 找到所有路径
    static ArrayList<ArrayList<Integer>> allPath(TreeNode root){
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root==null) return paths;
        if (root.left==null && root.right==null) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            paths.add(path);
        }
        if (root.left!=null){
            ArrayList<ArrayList<Integer>> left = allPath(root.left);
            for (ArrayList<Integer> p:left) {
                p.add(0, root.val);
                paths.add(p);
            }
        }
        if (root.right!=null){
            ArrayList<ArrayList<Integer>> right = allPath(root.right);
            for (ArrayList<Integer> p:right) {
                p.add(0, root.val);
                paths.add(p);
            }
        }
        return paths;
    }

}
