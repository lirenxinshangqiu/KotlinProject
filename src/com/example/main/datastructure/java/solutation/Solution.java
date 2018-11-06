package com.example.main.datastructure.java.solutation;

import com.example.main.datastructure.java.linklist.ListNode;

public class Solution {
    /**
     * 在链表中删除某个结点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
//            ListNode delNode = head;
            head = head.next;
//            delNode.next = null;
        }

        if (head == null) return null;

        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
//                ListNode delNode = pre.next;
//                pre = pre.next;
//                delNode.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public static ListNode removeElementsByDuymmy(ListNode head, int val) {
        ListNode duymmyHead = new ListNode(-1);
        duymmyHead.next = head;

        ListNode pre = duymmyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return duymmyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(listNode);
        System.out.println(removeElements(listNode, 2));
        System.out.println(removeElementsByDuymmy(listNode, 3));


    }

}
