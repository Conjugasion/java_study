package Algorithm.structure;

import java.util.*;

/**
 * @author Lucas
 * @date 2019-06-16 15:05
 */
public class newTree {
    class Node{
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node(int value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = null;
        }
    }

    static Node root;


    // 初始化 {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}  默认值不相同
    void init(int[] array){
        if (array.length == 0){
            System.out.println("error");
        }
        else {
            ArrayList<Node> nodes = new ArrayList<>();
            root = new Node(array[0]);
            nodes.add(root);
            for (int i = 1; i < array.length; i++) {
                nodes.add(new Node(array[i]));
            }
            for (int i = 0; i < nodes.size(); i++) {
                if (2*i+1 < nodes.size()){
                    nodes.get(i).left = nodes.get(2*i+1);
                    nodes.get(2*i+1).parent = nodes.get(i);
                    if (2*i+2 < nodes.size()){
                        nodes.get(i).right = nodes.get(2*i+2);
                        nodes.get(2*i+2).parent = nodes.get(i);
                    }
                }
            }
        }
    }

    // 获得节点
    static Node getNode(int value){
        if (root != null){
            ArrayList<Node> queue = new ArrayList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                Node pop = queue.remove(0);
                if (pop.value==value){
                    return pop;
                }
                if (pop.left!=null){
                    queue.add(pop.left);
                }
                if (pop.right!=null){
                    queue.add(pop.right);
                }
            }
        }
        return null;
    }

    // 获取某个节点的父节点
    Node getParent(Node node){
        if (root != null){
            ArrayList<Node> nodes = new ArrayList<>();
            nodes.add(root);

            while (!nodes.isEmpty()){
                Node pop = nodes.remove(nodes.size() - 1);
                if (pop.left==node||pop.right==node){
                    return pop;
                }
                if (pop.right!=null){
                    nodes.add(pop.right);
                }
                if (pop.left!=null){
                    nodes.add(pop.left);
                }
            }
        }
        return null;
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

    // 深度遍历 Stack
    void deepVisit2(){
        if (root != null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                Node pop = stack.pop();
                if (pop!=null){
                    System.out.print(pop.value + " ");
                    stack.push(pop.right);
                    stack.push(pop.left);
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
    // 广度遍历 queue
    void broadVisit2(){
        if (root != null){
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if (node!=null){
                    System.out.print(node.value + " ");
                    queue.offer(node.left);
                    queue.offer(node.right);
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
    void leftRotate(Node node){
        if (node.right == null){
            return;
        }
        else {
            if (node == root){
                Node right = node.right;
                right.parent = null;
                Node left = right.left;
                right.left = node;
                node.parent = right;
                node.right = left;
                left.parent = node;
                root = right;
            }
            else {
                Node right = node.right;
                right.parent = node.parent;
                if (node.parent.left == node){
                    node.parent.left = right;
                }
                else node.parent.right = right;
                Node left = right.left;
                right.left = node;
                node.parent = right;
                node.right = left;
                left.parent = node;
            }
        }
    }

    //  右旋
    void rightRotate(Node node){
        if (node.left == null){
            return;
        }
        else {
            if (node == root){
                Node left = node.left;
                left.parent = null;
                Node right = left.right;
                left.right = node;
                node.parent = left;
                node.left = right;
                right.parent = node;
                root = left;
            }
            else {
                Node left = node.left;
                left.parent = node.parent;
                if (node.parent.right == node){
                    node.parent.right = left;
                }
                else node.parent.left = left;
                Node right = left.right;
                left.right = node;
                node.parent = left;
                node.left = right;
                right.parent = node;
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
        if (direct.equals("left") &&node.left!=null){
            Node left = node.left;
            node.left = newNode;
            newNode.parent = node;
            left.parent = newNode;
            newNode.left = left;
        }
        else if (direct.equals("left") &&node.left==null){
            node.left = newNode;
            newNode.parent = node;
        }
        else if (direct.equals("right") &&node.left!=null){
            Node right = node.right;
            node.right = newNode;
            newNode.parent = node;
            right.parent = newNode;
            newNode.left = right;
        }
        else if (direct.equals("right") &&node.left==null){
            node.right = newNode;
            newNode.parent = node;
        }
        // 检测有没有失衡
        Node lostBalance = lostBalance(node);
        if (lostBalance!=null){
            keepBlance(lostBalance);
        }
    }

    /*
                      0
                  1       2
               3     4  5   6
             7   8  9
     */
    // 求两个节点的最近公共祖先
    public Node common(Node a, Node b){
        ArrayList<Node> aList = new ArrayList<>();
        ArrayList<Node> bList = new ArrayList<>();

        while (true){
            aList.add(a);
            if (a==root) break;
            a = a.parent;
        }
        /*for (Node i:aList) {
            System.out.print(" "+i.value);
        }*/
        while (true){
            bList.add(b);
            if (b==root) break;
            b = b.parent;
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
    Node lostBalance(Node node){
        // 检测各个父节点，看有没有失衡
        while (true){
            // 存在失衡节点返回节点，不存在返回null
            if (getHeight(node.left) - getHeight(node.right) >= 2 || getHeight(node.left) - getHeight(node.right) <= -2) return node;
            if (node==root) return null;
            node = node.parent;
        }
    }

    // 确定哪种旋转方式，一次左旋，一次右旋，一次左旋一次右旋，一次右旋一次左旋
    //                   右右     左左       左右            右左
    // 根据失衡节点，首先确定大类，左子树深还是右子树深
    // node = 失衡节点
    void keepBlance(Node node){
        // 左深
        if (getHeight(node.left) > getHeight(node)){
            Node left = node.left;
            // 左右插入，需要先左旋后右旋
            if (left.right!=null&&(left.right.left!=null||left.right.right!=null)){
                Node right = left.right;
                leftRotate(left);
                rightRotate(right);
            }
            else rightRotate(left);
        }
        // 右深
        else if (getHeight(node.left) < getHeight(node)) {
            Node right = node.right;
            // 右左插入，需要先右旋后左旋
            if (right.left!=null&&(right.left.right!=null||right.left.left!=null)){
                Node left = right.left;
                rightRotate(right);
                leftRotate(left);
            }
            else leftRotate(right);
        }
    }

    // 求树深度
    int TreeDepth(Node root) {
        if (root == null){
            return 0;
        }
        int leftnum = TreeDepth(root.left);
        int rightnum = TreeDepth(root.right);
        return Math.max(leftnum,rightnum)+1;
    }

    // 求树深度 非递归版
    int TreeDepth2(Node root){
        if (root!=null){
            Stack<Object[]> s1 = new Stack<>();
            s1.push(new Object[]{root,1});      // (node, depth)
            int maxDepth = 0;
            while (!s1.empty()){
                Object[] pop = s1.pop();
                if (pop[0]!=null){
                    Node node = (Node)pop[0];
                    int depth = (Integer)pop[1];
                    maxDepth = maxDepth > depth ? maxDepth : depth;
                    s1.push(new Object[]{node.right,depth+1});
                    s1.push(new Object[]{node.left,depth+1});
                }
            }
            return maxDepth;
        }else{
            return 0;
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
        System.out.println("前序遍历：");
        t.preVisit(root);
        System.out.println(" ");
        System.out.println("深度遍历：");
        t.deepVisit();
        System.out.println(" ");
        Node seven = getNode(7);
        System.out.println("7的父节点是: " + t.getParent(seven).value);
        System.out.println("递归版树深度是：" + t.TreeDepth(root));
        System.out.println("非递归版树深度是：" + t.TreeDepth2(root));
        //t.leftRotate(root);
        //t.broadVisit();
        System.out.println(" ");
        Node node1 = getNode(7);
        //Node node2 = getNode(4);
        //System.out.println("common: " + t.common(node1, node2).value);
        //Node testNode = getNode(2);
        //System.out.println("getHeight: " + t.getHeight(testNode));
        //Node newNode1 = t.new Node(10);
        //t.insert(node1, "left", newNode1);
        Node newNode2 = t.new Node(11);
        //t.insert(newNode1, "left", newNode2);
        System.out.println("广度遍历：");
        t.broadVisit2();
        System.out.println(" ");
        System.out.println("深度遍历：");
        t.deepVisit2();
        System.out.println(" ");
        //System.out.println("lostBlance: " + t.lostBalance(newNode1).value);
    }
}
