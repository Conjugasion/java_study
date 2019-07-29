package Algorithm.offer;

/**
 * @author Lucas
 * @date 2019-07-14 21:49
 */
public class SingleListJiaoDian {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    // 因为是单链表，所以交点之后的点都是相同的
    // 不需要记录链表长度，
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        int count1 = 0;
        int count2 = 0;

        while(temp1!=null){
            temp1 = temp1.next;
            temp2 = temp2 != null ? temp2.next:pHead1;
        }
        temp1 = pHead2;
        temp2 = temp2 != null ? temp2.next:pHead1;

        while(temp1!=null){
            if(temp1==temp2) return temp1;
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }

    // 因为是单链表，所以交点之后的点都是相同的
    // 需要记录链表长度，长链表先走 差值的步数
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        int count1 = 0;
        int count2 = 0;

        while (temp1!=null){
            temp1 = temp1.next;
            count1++;
        }
        while (temp2!=null){
            temp2 = temp2.next;
            count2++;
        }

        temp1 = pHead1;
        temp2 = pHead2;
        if (count1>count2){
            for(int i=1;i<=count1-count2;i++){
                temp1 = temp1.next;
            }
        }
        else if (count1<count2) {
            for(int i=1;i<=count2-count1;i++){
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            if(temp1==temp2) return temp1;
            else {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        return null;
    }
}
