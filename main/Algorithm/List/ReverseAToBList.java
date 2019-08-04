package Algorithm.List;

/**
 * @author Lucas
 * @date 2019-08-04 20:39
 * 指定范围的链表逆序
 * 1 2 3 4 5   将2~4逆序
 * 1 4 3 2 5
 */
public class ReverseAToBList {
    static class Node{
        int value;
        Node next=null;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static Node head;

    // 初始化
    static void init(int[] array){
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

    public static void main(String[] args) {
        init(new int[]{1,2,3,4,5,6,7,8,9});

    }



    // 普通版
    static Node reverseList(Node head){
        Node newHead = null;    // 指向新链表头结点的指针
        while (head!=null){
            Node next = head.next;    // 备份head.next     head -> 3 -> 4 -> 5
            head.next = newHead;      //                  newHead - > 2 -> 1
            newHead = head;           //                          4 -> 5
            head = next;              //                          3 -> 2 -> 1
        }
        return newHead;
    }
}
