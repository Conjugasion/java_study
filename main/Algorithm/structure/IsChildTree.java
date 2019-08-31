package Algorithm.structure;

import java.util.LinkedList;

/**
 * @author Lucas
 * @date 2019-08-31 15:35
 * 是否是子结构/子树
 */
public class IsChildTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        TreeNode left = root.left;
        left.left = new TreeNode(9);
        left.right = new TreeNode(2);
        TreeNode right = left.right;
        right.left = new TreeNode(4);
        right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(HasSubtree(root, root2));
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2==null||root1==null) return false;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root1);
        while(!nodes.isEmpty()){
            TreeNode node = nodes.poll();
            if (node.val==root2.val){
                if(check(node, root2)) return true;
            }
            if(node.left!=null){
                nodes.offer(node.left);
            }
            if(node.right!=null){
                nodes.offer(node.right);
            }
        }
        return false;
    }

    static boolean check(TreeNode node1, TreeNode node2){
        if (node2.left==null&&node2.right==null) return true;
        else if (node2.left==null){
            return node1.right != null && node1.right.val == node2.right.val && check(node1.right, node2.right);
        }
        else if (node2.right==null){
            return node1.left != null && node1.left.val == node2.left.val && check(node1.left, node2.left);
        }
        else return node1.left!=null && node1.right!=null && node1.left.val == node2.left.val && node1.right.val == node2.right.val && check(node1.right, node2.right) && check(node1.left, node2.left);
    }
}
