package Algorithm.structure;

/**
 * @author Lucas
 * @date 2019-06-25 09:12
 */
public class SingleList {
    class Node{
        int value;
        Node next=null;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    // 初始化
    void init(int[] array){
        if (array.length!=0){
            head = new Node(array[0]);
            Node temp = head;
            for (int i = 1; i < array.length; i++) {
                Node node = new Node(array[i]);
                temp.next = node;
                temp = node;
            }
        }
    }

    // 反转单链表   1 2 3 4
    void reverse(){
        if (head.next!=null){
            Node current = head;
            Node preNode = null;
            Node nextNode = null;
           while (current!=null){
               nextNode = current.next;
               current.next = preNode;
               preNode = current;
               current = nextNode;
           }
           head = preNode;
        }
    }

    // 递归版
    Node reverse(Node node){
        if (node==null || node.next==null){
            return node;
        }
        Node nextNode = node.next;
        Node reverseHead = reverse(nextNode);
        nextNode.next = node;
        node.next = null;
        head = reverseHead;
        return reverseHead;
    }


    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9};
        SingleList list = new SingleList();
        list.init(array);
        //list.reverse();
        list.reverse(list.head);
    }
}
