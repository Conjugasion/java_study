package algorithm.offer;

/**
 * @author Lucas
 * @date 2019/5/28 21:53
 * 根据中序和后序恢复二叉树
 */
public class problem4_1 {
    class treeNode{
        int val;
        treeNode left;
        treeNode right;

        public treeNode(int val){
            this.val = val;
        }
    }

    public treeNode reConstructBinaryTree(int[] in, int[] post){
        treeNode root = build(in, 0, in.length - 1, post, 0, post.length - 1);
        return root;
    }

    public treeNode build(int[] in, int startin, int endin, int[] post, int postin, int postend){
        if (startin > endin || postin > postend){
            return null;
        }
        treeNode root = new treeNode(post[postend]);
        for (int i = startin; i <= endin; i++) {
            if (in[i] == post[postend]){
                root.left = build(in, startin, i-1, post, postin, postin+i-startin-1);
                root.right = build(in,i+1, endin, post, postin+i-startin ,postend-1);
                break;
            }
        }
        return root;
    }

    // 前序
    public void preVisit(treeNode root){
        if (root != null){
            System.out.print(root.val + " ");
            preVisit(root.left);
            preVisit(root.right);
        }
    }

    public static void main(String[] args) {
        int[] in = {4,7,2,1,5,3,8,6};
        int[] post = {7,4,2,5,8,6,3,1};
        problem4_1 problem4_1 = new problem4_1();
        treeNode root = problem4_1.reConstructBinaryTree(in, post);
        problem4_1.preVisit(root);  // 1 2 4 7 3 5 6 8
    }
}
