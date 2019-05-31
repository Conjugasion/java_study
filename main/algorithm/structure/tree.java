package algorithm.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 18:39
 * 二叉树
 */
public class tree {

    class node{
        node left;
        node right;
        int value;

        public node(node left, node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public node() {
        }

        public node getLeft() {
            return left;
        }

        public void setLeft(node left) {
            this.left = left;
        }

        public node getRight() {
            return right;
        }

        public void setRight(node right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private node root;

    public tree(node root) {
        this.root = root;
    }


    public tree() {}

    public node getRoot() {
        return root;
    }

    public void setRoot(node root) {
        this.root = root;
    }

    // 数组 初始化二叉树
    public void init(int[] array){
        List<node> nodeList = new ArrayList<>();
        if (array.length == 0){
            System.out.println("数组不能为空");
        }
        else {
            for (int i : array) {
                nodeList.add(new node(null, null, i));
            }

            root = nodeList.get(0);

            for (int i = 0; i < array.length/2; i++) {
                nodeList.get(i).setLeft(nodeList.get(2*i+1));
                if (2*i+2 < array.length){
                    nodeList.get(i).setRight(nodeList.get(2*i+2));
                }
            }
        }
    }

    // 前序遍历二叉树
    public static void preVisit(node root){
        if (root != null){
            System.out.print(root.value + " ");
            preVisit(root.left);
            preVisit(root.right);
        }
    }
    // 中序遍历二叉树
    public static void midVisit(node root){
        if (root != null){
            midVisit(root.left);
            System.out.print(root.value + " ");
            midVisit(root.right);
        }
    }
    // 后序遍历二叉树
    public static void postVisit(node root){
        if (root != null){
            postVisit(root.left);
            postVisit(root.right);
            System.out.print(root.value + " ");
        }
    }
    // 深度遍历
    public static void deepVisit(node root){
        if (root != null){
            List<node> stack = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()){
                node pop = stack.remove(stack.size()-1);
                System.out.print(pop.value + " ");
                if (pop.right != null){
                    stack.add(pop.right);
                }
                if (pop.left != null){
                    stack.add(pop.left);
                }
            }
        }
    }
    // 广度遍历
    public static void broadVisit(node root){
        if (root != null){
            List<node> queue = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                node pop = queue.remove(0);
                System.out.print(pop.value + " ");
                if (pop.left != null){
                    queue.add(pop.left);
                }
                if (pop.right != null){
                    queue.add(pop.right);
                }
            }
        }
    }


    public static void main(String[] args) {
        tree t = new tree();
        t.init(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        /*
                      0
                  1       2
               3     4  5   6
             7   8  9
         */
        //preVisit(t.root); // 0 1 3 7 8 4 9 2 5 6
        //midVisit(t.root); // 7 3 8 1 9 4 0 5 2 6
        //postVisit(t.root); // 7 8 3 9 4 1 5 6 2 0
        //deepVisit(t.root);
        broadVisit(t.root);
    }
}