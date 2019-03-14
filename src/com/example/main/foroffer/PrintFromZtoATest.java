package com.example.main.foroffer;

import java.util.Stack;
import java.util.StringJoiner;

/**
 *翻转链表
 * 解题思路：利用栈翻转
 */
public class PrintFromZtoATest {
    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0);
        System.out.println(head);
        printFormZToA(head);
        printFromZtoA(head);
    }

    private static void printFormZToA(ListNode head){
        Stack<Integer> stack = new Stack<>();
        if (head == null) {
            return;
        }
        ListNode next = head;
        while (next!=null){
            stack.push(next.value);
            next  = next.next;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
            if (!stack.isEmpty()) {
                System.out.print("->");
            }
        }
        System.out.println();
    }

    /**
     * 递归方法翻转
     * @param head
     */
    private static void printFromZtoA(ListNode head){
        if (head != null) {
            printFromZtoA(head.next);
            System.out.print(head.value+"->");
        }
    }
}

class ListNode {
    public int value;
    public ListNode next;

    public static ListNode create(int[] array, int index) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (index>= array.length) return null;
        ListNode listNode = new ListNode();
        listNode.value = array[index++];
        listNode.next = create(array, index);
        return listNode;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner("->", "[", "]");
        stringJoiner.add(String.valueOf(value));
        ListNode nextNode = next;
        while (nextNode != null) {
            stringJoiner.add(String.valueOf(nextNode.value));
            nextNode = nextNode.next;
        }
        return stringJoiner.toString();
    }
}
