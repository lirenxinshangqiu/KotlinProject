package com.example.main.foroffer;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 *
 ①遍历。将指向下一个节点的指针指向上一个节点。

 ②递归。先让指向下一个节点的指针为空，然后递归调用，最后再将指向下一个节点的指针指向上一个节点。
 */
public class LinkListResverTest {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create(new int[]{1, 2, 3, 4, 5, 6}, 0);
        ListNode listNode1 = ListNode.create(new int[]{1, 2, 3, 4, 5, 6}, 0);
        ListNode listNode2 = ListNode.create(new int[]{1, 2, 3, 4, 5, 6}, 0);
        ListNode listNode3 = ListNode.create(new int[]{1, 2, 3, 4, 5, 6}, 0);
        System.out.println(resverListNode(listNode));
        System.out.println(resverListNodeByRecur(listNode1));
        System.out.println(merge(listNode2,listNode3));
    }

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的
     *
     * @param head1 第一个有序链表
     * @param head2 第二个有序链表
     * @return 合并后的有序链表头
     */
    public static ListNode merge(ListNode head1, ListNode head2) {
        // 如果第一个链表为空，返回第二个链表头结点
        if (head1 == null) {
            return head2;
        }

        // 如果第二个结点为空，返回第一个链表头结点
        if (head2 == null) {
            return head1;
        }

        // 创建一个临时结点，用于添加元素时方便
        ListNode root = new ListNode();
        // 用于指向合并后的新链的尾结点
        ListNode pointer = root;

        // 当两个链表都不为空就进行合并操作
        while (head1 != null && head2 != null) {
            // 下面的操作合并较小的元素
            if (head1.value < head2.value) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }

            // 将指针移动到合并后的链表的末尾
            pointer = pointer.next;
        }

        // 下面的两个if有且只一个if会内的内容会执行

        // 如果第一个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head1 != null) {
            pointer.next = head1;
        }

        // 如果第二个链表的元素未处理完将其，接到合并链表的最后一个结点之后
        if (head2 != null) {
            pointer.next = head2;
        }

        // 返回处理结果
        return root.next;
    }

    private static ListNode resverListNodeByRecur(ListNode current){
        if (current == null ||current.next ==null) {
            return current;
        }
        ListNode next = current.next;
        current.next =null;
        ListNode listNode = resverListNodeByRecur(next);
        next.next = current;
        return listNode;
    }
    private static ListNode resverListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
       ListNode pre = head;
        ListNode current = head.next;
        ListNode next = null;
        while (current!=null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        head.next = null;
        head = pre;
        return head;
    }
}
