package algorithm.structure;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-06-16 15:05
 */
public class newTree {
    class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    Node root;
    ArrayList<Node> nodes = new ArrayList<>();

    // 初始化 {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
    void init(int[] array){
        if (array.length == 0){
            System.out.println("error");
        }
        else {
            root = new Node(array[0]);
            nodes.add(root);
            for (int i = 1; i < array.length; i++) {
                nodes.add(new Node(array[i]));
            }
            for (int i = 0; i < nodes.size(); i++) {
                if (2*i+1 < nodes.size()){
                    nodes.get(i).left = nodes.get(2*i+1);
                    if (2*i+2 < nodes.size()){
                        nodes.get(i).right = nodes.get(2*i+2);
                    }
                }
            }
        }
    }

    // 获得节点
    Node getNode(int index){
        return nodes.get(index);
    }

    // 前序遍历
    void preVisit(Node root){
         if (root != null){
             System.out.print(root.value + " ");
             preVisit(root.left);
             preVisit(root.right);
         }
    }

    // 深度遍历
    void deepVisit(){
        if (root != null){
            ArrayList<Node> stack = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()){
                Node pop = stack.remove(stack.size() - 1);
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
    void broadVisit(){
        if (root != null){
            ArrayList<Node> queue = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                Node pop = queue.remove(0);
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

    // 指定节点左旋
    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
     */
    void rotate(Node node){
        if (node.right == null){
            return;
        }
        else {
            if (node == root){
                Node right = node.right;
                Node left = right.left;
                right.left = node;
                node.right = left;
                root = right;
            }
            else {
                int i = nodes.indexOf(node);
                int pid = i%2==0 ? (i-2)/2 : (i-1)/2;
                Node parent = nodes.get(pid);
                if (i%2==0){
                    parent.right = node.right;
                    node.right = node.right.left;
                }
                else {
                    parent.left = node.right;
                    node.right = node.right.left;
                }
            }
        }
    }


    public static void main(String[] args) {
        newTree t = new newTree();
        t.init(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        //t.preVisit(t.root);
        System.out.println(" ");
        //t.deepVisit();
        t.rotate(t.root);
        t.broadVisit();
    }
}
