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

    static Node root;
    static ArrayList<Node> nodes = new ArrayList<>();

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

    // 插入节点  那个节点，插入左/右，新节点, 原来的子树置于新节点的左边
    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
           10
     */
    void insert(Node node, String direct, Node newNode){
        int index = nodes.indexOf(node);
        if (direct=="left"){
            int size = nodes.size();
            for (int i = size-1; i <= 2*index + 1; i++) {
                if (i == 2*index + 1) nodes.add(newNode);
                else nodes.add(null);
            }
            Node left = node.left;
            newNode.left = left;
            node.left = newNode;
            nodes.add(node);
        }
        else {
            int childIndex = 2*index + 2;
            Node right = node.right;
            newNode.left = right;
            node.right = newNode;
            nodes.add(node);
        }
    }

    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
     */
    // 求两个节点的最近公共祖先
    public Node common(int a, int b){
        ArrayList<Node> aList = new ArrayList<>();
        ArrayList<Node> bList = new ArrayList<>();

        while (true){
            aList.add(nodes.get(a));
            if (a == 0){
                break;
            }
            if (a%2==0){
                a = (a-2)/2;
            }
            else {
                a = (a-1)/2;
            }
        }
        /*for (Node i:aList) {
            System.out.print(" "+i.value);
        }*/
        while (true){
            bList.add(nodes.get(b));
            if (b == 0){
                break;
            }
            if (b%2==0){
                b = (b-2)/2;
            }
            else {
                b = (b-1)/2;
            }
        }
        /*System.out.println(" ");
        for (Node i:bList) {
            System.out.print(" "+i.value);
        }*/
        for (Node i : aList) {
            for (Node j : bList) {
                if (i==j){
                    return i;
                }
            }
        }
        return null;
    }

    // 获得节点深度
    int getHeight(Node node){
        if (node==null){
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // 寻找失去平衡的节点 从插入节点的父节点入手, node = 插入节点
    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
           10
     */
    Node lostBlance(Node node){
        int index = nodes.indexOf(node);
        // 检测各个父节点，看有没有失衡
        while (true){
            Node parent;
            if (index%2==0){
                index = (index-2)/2;
                parent = nodes.get(index);
            }
            else {
                index = (index-1)/2;
                parent = nodes.get(index);
            }
            // 存在失衡节点返回节点，不存在返回null
            if (getHeight(parent.left) - getHeight(parent.right) >= 2 || getHeight(parent.left) - getHeight(parent.right) <= -2) return parent;
            if (parent==root) return null;
        }
    }

    // 确定哪种旋转方式，一次左旋，一次右旋，一次左旋一次右旋，一次右旋一次左旋
    //                   右右     左左       左右            右左
    // 根据失衡节点，首先确定大类，左子树深还是右子树深
    void keepBlance(Node node){
        // 左深
        if (getHeight(node.left) > getHeight(node)){

        }
        else if (getHeight(node.left) < getHeight(node)) {

        }
    }

    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
           10
         11
     */
    public static void main(String[] args) {
        newTree t = new newTree();
        t.init(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        //t.preVisit(root);
        System.out.println(" ");
        //t.deepVisit();
        //t.rotate(t.root);
        //t.broadVisit();
        System.out.println(" ");
        System.out.println("common: " + t.common(7, 4).value);
        Node testNode = t.getNode(2);
        System.out.println("getHeight: " + t.getHeight(testNode));
        Node newNode1 = t.new Node(10);
        t.insert(nodes.get(7), "left", newNode1);
        Node newNode2 = t.new Node(11);
        t.insert(newNode1, "left", newNode2);
        t.broadVisit();
        System.out.println(" ");
        System.out.println("lostBlance: " + t.lostBlance(newNode1).value);
    }
}
