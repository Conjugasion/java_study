package algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lucas
 * @date 2019/5/28 19:43
 * 根据前序和中序重建二叉树
 * 前序遍历第一个一定是root，找到root在中序遍历中所在的位置
 * 其左边就是它的左子树，其右边就是它的右子树
 */
public class MidAndPreRevertTree {
    class treeNode{
        int val;
        treeNode left;
        treeNode right;
        public treeNode(int val){
            this.val = val;
        }
    }

    public treeNode reConstructBinaryTree(int[] pre, int[] in){
        treeNode root = build(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public treeNode build(int[] pre, int startpre, int endpre , int[] in, int startin, int endin){
        if (startpre > endpre || startin > endin){
            return null;
        }
        treeNode root = new treeNode(pre[startpre]);

        for (int i = startin; i <= endin; i++) {
            if (in[i] == pre[startpre]){
                root.left = build(pre, startpre+1, startpre+i-startin, in, startin, i-1);
                root.right = build(pre, startpre+i-startin+1, endpre, in, i+1, endin);
                break;
            }
        }
        return root;
    }

    // 后序
    public void postVisit(treeNode root){
        if (root != null){
            postVisit(root.left);
            postVisit(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        /*
                  1
              2        3
            4        5   6
              7         8
         */
        MidAndPreRevertTree problem4 = new MidAndPreRevertTree();
        treeNode root = problem4.reConstructBinaryTree(pre, in);
        problem4.postVisit(root);
    }
}
