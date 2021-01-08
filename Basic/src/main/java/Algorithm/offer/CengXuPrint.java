package Algorithm.offer;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Lucas
 * @date 2019-07-21 15:45
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class CengXuPrint {
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

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(pRoot==null) return list;
        int layer = 1;
        LinkedBlockingQueue<TreeNode> q1 = new LinkedBlockingQueue<>();
        q1.offer(pRoot);
        LinkedBlockingQueue<TreeNode> q2 = new LinkedBlockingQueue<>();
        while(!q1.isEmpty()||!q2.isEmpty()){
            if(layer%2!=0){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!q1.isEmpty()){
                    TreeNode node = q1.poll();
                    if(node!=null){
                        temp.add(node.val);
                        q2.offer(node.left);
                        q2.offer(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                while(!q2.isEmpty()){
                    TreeNode node = q2.poll();
                    if(node!=null){
                        temp.add(node.val);
                        q1.offer(node.left);
                        q1.offer(node.right);
                    }
                }
                if(!temp.isEmpty()){
                    list.add(temp);
                    layer++;
                }
            }
        }
        return list;
    }
}
