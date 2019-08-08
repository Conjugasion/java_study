package Algorithm.structure;

/**
 * @author Lucas
 * @date 2019/8/7 9:44
 * 中序后序重建二叉树
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 */
public class PostMidBuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;
        }
    }

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight){
        if (inLeft>inRight || postLeft>postRight) return null;

        TreeNode root = new TreeNode(postorder[postRight]);
        int inRoot = 0;
        for (int i = inLeft; i <= inRight; i++) {              // 找根
            if (inorder[i] == postorder[postRight]){           // 左子树长度 inRoot - inLeft 右子树长度 inRight - inRoot
                inRoot = i;
                break;
            }
        }

        root.left = build(inorder, postorder, inLeft, inRoot-1, postLeft,postRight-(inRight - inRoot)-1);
        root.right = build(inorder, postorder, inRoot+1, inRight, postRight-(inRight - inRoot), postRight-1);
        return root;
    }
}
