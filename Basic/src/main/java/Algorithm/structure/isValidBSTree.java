package Algorithm.structure;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019/8/7 10:15
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class isValidBSTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        if (root.left==null && root.right==null) return true;
        if (root.left==null) {
            // 根节点小于右节点，根节点小于右子树中的最小值，右子树也是搜索二叉树
            return root.right.val > root.val && searchMin(root.right) > root.val && isValidBST(root.right);
        }
        if (root.right == null) {
            return root.left.val < root.val && searchMax(root.left) < root.val && isValidBST(root.left);
        }
        return root.left.val < root.val && root.right.val > root.val && searchMax(root.left) < root.val && searchMin(root.right) > root.val && isValidBST(root.left) && isValidBST(root.right);
    }

    long searchMax(TreeNode leftNode) {
        long max = Long.MIN_VALUE;
        while (leftNode!=null){
            max = max >= leftNode.val ? max : leftNode.val;
            leftNode = leftNode.right;
        }
        return max;
    }

    int searchMin(TreeNode rightNode){
        int min = Integer.MAX_VALUE;
        while (rightNode!=null){
            min = min <= rightNode.val ? min : rightNode.val;
            rightNode = rightNode.left;
        }
        return min;
    }

    // 搜索二叉树中序遍历是递增的
    public boolean ValidBST(TreeNode root){
        if (root==null) return true;
        ArrayList<Integer> result = new ArrayList<>();
        midVisit(root, result);
        for (int i = 0; i < result.size()-1; i++) {
            if (result.get(i)>=result.get(i+1)){
                return false;
            }
        }
        return true;
    }

    // 中序遍历
    void midVisit(TreeNode root, ArrayList<Integer> result){
        if (root!=null){
            midVisit(root.left, result);
            result.add(root.val);
            midVisit(root.right, result);
        }
    }
}
