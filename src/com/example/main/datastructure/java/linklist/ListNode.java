package com.example.main.datastructure.java.linklist;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] array){
        if (array ==null || array.length<=0){
            throw new IllegalArgumentException("数组不能为空");
        }
        this.val = array[0];
        ListNode cur = this;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ListNode:[");
        sb.append(val);
        ListNode node = next;
        while (node != null) {
            sb.append("->" + node.val);
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
