package Algorithm.structure;

import java.util.*;

/**
 * @author Lucas
 * @date 2019/8/9 11:05
 * 给定一个二叉树，返回其按层次遍历的节点值。(即逐层地，从左到右访问所有节点)
 * [[3],[9,20],[15,7]]
 */
public class LevelOrderVisitTree {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static TreeNode root;
    // 数组 初始化二叉树
    static void init(int[] array){
        List<TreeNode> nodeList = new ArrayList<>();
        if (array.length == 0){
            System.out.println("数组不能为空");
        }
        else {
            for (int i : array) {
                nodeList.add(new TreeNode(i));
            }

            root = nodeList.get(0);

            for (int i = 0; i < array.length/2; i++) {
                nodeList.get(i).left = nodeList.get(2*i+1);
                if (2*i+2 < array.length){
                    nodeList.get(i).right = nodeList.get(2*i+2);
                }
            }
        }
    }

    // 逐层遍历二叉树
    static void levelOrder(TreeNode root) {
        HashMap<Integer, ArrayList<Integer>> level = new HashMap<>();
        Queue<Object[]> q = new LinkedList<>();     // { 层数, TreeNode }
        q.offer(new Object[]{1, root});

        while (!q.isEmpty()) {
            Object[] node = q.poll();
            if (level.containsKey(node[0])){
                level.get(node[0]).add(((TreeNode)node[1]).val);
            } else {
                level.put((int)node[0], new ArrayList<Integer>(){{add(((TreeNode)node[1]).val);}});
            }
            if (((TreeNode)node[1]).left != null){
                q.offer(new Object[]{(int)node[0]+1, ((TreeNode)node[1]).left});
            }
            if (((TreeNode)node[1]).right != null){
                q.offer(new Object[]{(int)node[0]+1, ((TreeNode)node[1]).right});
            }
        }
        for (int i:level.keySet()) {
            System.out.println(level.get(i));
        }
    }

    public static void main(String[] args) {
        init(new int[]{3,9,20,15,7});
        levelOrder(root);
    }
}
