package com.example.main.datastructure.java.queue;

import com.example.main.datastructure.java.linklist.LinkedList;

/**
 * Created by ls on 18/7/17.
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head;
    private Node tail;
    private int size;


    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("为空！");
        }
        Node retNode = this.head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("为空！");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder buider = new StringBuilder();
        buider.append("Queue: front");
        Node cur = head;
        while (cur != null) {
            buider.append(cur + "->");
            cur = cur.next;
        }
        buider.append("null tail");
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

    public static void main(String[] args) {
        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 2) {
                System.out.println(arrayQueue.dequeue());
            }
            System.out.println(arrayQueue);
        }
    }
}
