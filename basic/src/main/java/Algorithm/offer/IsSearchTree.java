package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-15 20:58
 * 是否是二叉排序树
 */
public class IsSearchTree {

    public static void main(String[] args) {
        IsSearchTree BalancedTree = new IsSearchTree();
        TreeNode root = BalancedTree.new TreeNode(1);
        TreeNode node1 = BalancedTree.new TreeNode(1);
        TreeNode node2 = BalancedTree.new TreeNode(1);
        TreeNode node3 = BalancedTree.new TreeNode(1);
        TreeNode node4 = BalancedTree.new TreeNode(1);
        TreeNode node5 = BalancedTree.new TreeNode(1);
        root.right = node1;
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        boolean b = BalancedTree.IsSearch_Solution(root);
        System.out.println(b);
    }

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
            this.val = val;
         }
     }


    public boolean IsSearch_Solution(TreeNode root) {
        if (root==null){
            return true;
        }
        else if(root.left!=null&&root.right!=null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            boolean leftB = IsSearch_Solution(left);
            boolean rightB = IsSearch_Solution(right);
            int leftMax = 0;
            int rightMin = 0;
            while(left!=null){
                leftMax = left.val;
                left = left.right;
            }
            while(right!=null){
                rightMin = right.val;
                right = right.left;
            }
            if (leftB&&rightB&&left.val<=right.val&&leftMax<=root.val&&root.val<=rightMin) return true;
            else return false;
        }
        else if(root.left!=null&&root.right==null){
            TreeNode left = root.left;
            boolean leftB = IsSearch_Solution(left);
            int leftMax = 0;
            while(left!=null){
                leftMax = left.val;
                left = left.right;
            }
            if (leftB&&leftMax<=root.val) return true;
            else return false;
        }
        else if(root.left==null&&root.right!=null){
            TreeNode right = root.right;
            boolean rightB = IsSearch_Solution(right);
            int rightMin = 0;
            while(right!=null){
                rightMin = right.val;
                right = right.left;
            }
            if (rightB&&root.val<=rightMin) return true;
            else return false;
        }
        else return true;
    }

}
