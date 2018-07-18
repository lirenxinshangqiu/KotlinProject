package com.example.main.datastructure.java.linklist;

/**
 * 线性链表
 * Created by ls on 18/7/17.
 */
public class LinkedList<E> {
    private int size;
    private Node dummyHead;//虚拟链表头节点

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 链表开头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表指定索引添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (isIllegal(index)) {
            throw new IllegalArgumentException("添加失败，输入的index有误！");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //找到第index个节点，然后把要添加的元素的next节点指向 第index-1个节点的后继节点。要添加节点的next指向要下一个的元素
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /**
     * 在链表末尾添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (isIllegal(index)) {
            throw new IllegalArgumentException("添加失败，输入的index有误！");
        }
        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getlast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    /**
     * 修改链表中元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (isIllegal(index)) {
            if (isIllegal(index)) {
                throw new IllegalArgumentException("添加失败，输入的index有误！");
            }
        }

        Node cur = dummyHead;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查找链表中是否有特定元素
     *
     * @param e
     * @return
     */
    public boolean constain(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) return true;
            cur = cur.next;
        }
        return false;
    }

    public void remove(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            Node delNode = cur.next;
            if (delNode != null && delNode.e.equals(e)) {
                cur.next = delNode.next;
                delNode = null;
                size--;
                break;
            }
            cur = cur.next;
        }
    }

    public E remove(int index) {
        if (isIllegal(index)) {
            throw new IllegalArgumentException("输入的index有误！");
        }
        if (size == 0){
            return null;
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        E element = delNode.e;
        pre.next = delNode.next;
        delNode = null;
        size--;
        return element;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }


    private boolean isIllegal(int index) {
        return index < 0 || index > size;
    }

    @Override
    public String toString() {
        StringBuilder buider = new StringBuilder();
        Node cur = dummyHead;
        while (cur != null) {
            buider.append(cur + "->");
            cur = cur.next;
        }
        buider.append("null");
        return buider.toString();

    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    '}';
        }
    }
}
