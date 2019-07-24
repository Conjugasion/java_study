package algorithm.structure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Lucas
 * @date 2019-06-16 20:18
 * 搜索二叉树
 */
public class searchTree {
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

    // 初始化搜索二叉树
    void init(int[] array){
        if (array.length == 0){
            System.out.println("error");
        }
        root = new Node(array[0]);
        nodes.add(root);
        for (int i = 1; i < array.length; i++) {
            nodes.add(new Node(array[i]));
        }

        for (int i = 1; i < nodes.size(); i++) {
            Node current = root;
            while (true){
                if (nodes.get(i).value <= current.value){
                    if (current.left == null){
                        current.left = nodes.get(i);
                        break;
                    }
                    else current = current.left;
                }
                else {
                    if (current.right == null){
                        current.right = nodes.get(i);
                        break;
                    }
                    else current = current.right;
                }
            }
        }
    }

    // 插入
    void insert(Node node){
        Node current = root;
        while (true){
            if (node.value <= current.value){
                if (current.left == null){
                    current.left = node;
                    break;
                }
                else current = current.left;
            }
            else {
                if (current.right == null){
                    current.right = node;
                    break;
                }
                else current = current.right;
            }
        }
    }

    // 中序遍历
    static Stack<Node> nodeStack = new Stack<Node>();
    void midVisit(Node root, Stack<Node> nodeStack){
        if (root != null){
            midVisit(root.left, nodeStack);
            nodeStack.push(root);
            midVisit(root.right, nodeStack);
        }
    }

    // 返回第k个节点
    static int index = 0; //计数器
    static Node findK(Node pRoot, int k){

        if(pRoot != null){ //中序遍历寻找第k个
            Node node = findK(pRoot.left,k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = findK(pRoot.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    public static void main(String[] args) {
        // -150 -5 0 12 15 20 20 25 100 126 200 1000
        int[] array = {20, 15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
        searchTree searchTree = new searchTree();
        searchTree.init(array);
        //searchTree.midVisit(searchTree.root, nodeStack);
        /*for (Node n:nodeStack) {
            System.out.print(n.value + " ");
        }*/
        System.out.println("\r");
        searchTree.Node insertNode = searchTree.new Node(123);
        searchTree.insert(insertNode);
        searchTree.midVisit(searchTree.root, nodeStack);
        System.out.println("寻找第k个节点：" + findK(searchTree.root, 10).value);
    }
}
