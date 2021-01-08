package Algorithm.offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019-05-26 17:07
 * 链表从尾到头输出ArrayList
 */
public class problem3 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode temp = new ListNode(0);
        ListNode listNode = temp;
        for (int i = 1; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        System.out.println(printListFromTailToHead(listNode));
        ArrayList<Integer> l1 = new ArrayList<>();
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null){
            return new ArrayList<Integer>();
        }
        ListNode temp = listNode;
        int length = 1;
        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[length - 1 -i] = listNode.val;
            if (listNode.next != null){
                listNode = listNode.next;
            }
        }
        return new ArrayList<>(Arrays.asList(array));
    }
}
