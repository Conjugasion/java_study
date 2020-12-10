package Algorithm.structure;

/**
 * @author Lucas
 * @date 2019/8/7 9:58
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class isSymmetricTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot==null && rightRoot==null) return true;
        if (leftRoot==null || rightRoot==null) return false;
        if (leftRoot.val!=rightRoot.val) return false;
        return isSymmetric(leftRoot.left, rightRoot.right) && isSymmetric(leftRoot.right, rightRoot.left);
    }
}
