package Algorithm.structure;

/**
 * @author Lucas
 * @date 2019/8/7 9:15
 * 根据一棵树的前序遍历与中序遍历构造二叉树。树中没有重复的元素。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 */
public class PreMidBuildTree {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x;
      }
    }
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft>preRight||inLeft>inRight) return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRoot = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i]==preorder[preLeft]){
                inRoot = i;                           // 找到根节点在中序遍历中的 索引
                break;                                // 左子树长度 inRoot-inLeft 右子树长度 inRIght-inRoot
            }
        }
        TreeNode leftTree = build(preorder, inorder, preLeft + 1, preLeft + inRoot - inLeft, inLeft, inRoot - 1); // 递归左子树
        TreeNode rightTree = build(preorder, inorder, preLeft + inRoot - inLeft + 1, preRight, inRoot + 1, inRight); // 递归右子树
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}
