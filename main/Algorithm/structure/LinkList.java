package Algorithm.structure;


/**
 * @author Lucas
 * @date 2019/6/13 15:32
 */
public class LinkList {
    class Node {
        int value;
        Node next=null;
        Node pre=null;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node pre) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    Node head;

    // 初始化双链表
    public void init(int[] array){
        if (array.length != 0){
            head = new Node(array[0]);
            Node temp = head;
            for (int i = 1; i < array.length; i++) {
                Node node = new Node(array[i]);
                temp.next = node;
                node.pre = temp;
                temp = node;
            }
        }
    }

    // 获得双链表长度
    public int size(){
        int count = 0;
        Node temp = head;
        if (temp==null){
            return count;
        }
        else {
            while (temp != null){
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    //获得元素
    public int get(int index){
        if (index < 0 || index >= this.size()) {
            System.out.println("越界");
        }
        else if (index==0) {
            return head.value;
        }
        else {
            Node temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
            return temp.value;
        }
        return -1;
    }

    // 获得指定索引Node
    private Node getNode(int index){
        if (index < 0 || index >= this.size()){
            System.out.println("越界");
            return null;
        }
        else if (index==0){
            return head;
        }
        else {
            Node temp = head;
            for (int i = 1; i <= index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    // 尾部插入元素
    public void add(int ele){
        Node tail = getNode(this.size()-1);
        Node node = new Node(ele, null, tail);
        tail.next = node;
    }

    // 删除指定索引元素
    public void remove(int index){
        if (index < 0 || index >= this.size()){
            System.out.println("越界");
        }
        else if (index == 0){
            head.next.pre = null;
            head = head.next;
        }
        else {
            Node node = getNode(index);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.init(new int[]{1, 2, 3, 4, 5, 6});
        Node head = linkList.head;
        System.out.println(linkList.size());
        linkList.add(7);
        linkList.remove(5);
        for (int i = 0; i < linkList.size(); i++) {
            System.out.println(linkList.get(i));
        }
    }
}
