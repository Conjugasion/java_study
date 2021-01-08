package Algorithm.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/9/4 19:30
 */
public class LinkedListSort {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head,int m) {
        ArrayList<ListNode> firstList = new ArrayList<>();
        ArrayList<ListNode> behindList = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            if (temp.val<=m){
                firstList.add(new ListNode(temp.val));
            }else {
                behindList.add(new ListNode(temp.val));
            }
            temp = temp.next;
        }
        if (firstList.size()>0){
            ListNode newHead = firstList.get(0);
            ListNode newTemp1 = newHead;
            for (int i = 1; i < firstList.size(); i++) {
                newTemp1.next = firstList.get(i);
                newTemp1 = firstList.get(i);
            }
            ListNode newLast = firstList.get(firstList.size()-1);
            ListNode newTemp2 = newLast;
            for (int i = 0; i < behindList.size(); i++) {
                newTemp2.next = behindList.get(i);
                newTemp2 = behindList.get(i);
            }
            return newHead;
        }else {
            if (behindList.size()>0){
                ListNode newHead = behindList.get(0);
                ListNode newTemp1 = newHead;
                for (int i = 1; i < behindList.size(); i++) {
                    newTemp1.next = behindList.get(i);
                    newTemp1 = behindList.get(i);
                }
                return newHead;
            }else {
                return null;
            }

        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }
        head= partition(head,m);
        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }
        System.out.println();
    }
}
