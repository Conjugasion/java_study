package algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-15 21:50
 * 是否是平衡二叉树
 */
public class IsBalancedTree {
    public static void main(String[] args) {

    }
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        int leftDeep = TreeDepth(root.left);
        int rightDeep = TreeDepth(root.right);
        if (left&&right){
            if (leftDeep>=rightDeep&&leftDeep-rightDeep<=1){
                return true;
            }
            else if (leftDeep<rightDeep&&leftDeep-rightDeep>=-1){
                return true;
            }
            else return false;
        }
        else return false;
    }

    // 求树深度
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftnum = TreeDepth(root.left);
        int rightnum = TreeDepth(root.right);
        return Math.max(leftnum,rightnum)+1;
    }
}
