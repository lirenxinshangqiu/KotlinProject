package com.example.main.datastructure.java.queue;

import com.example.main.datastructure.java.array.Array;

/**
 * 数组队列
 * Created by ls on 18/7/16.
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Queue:");
        builder.append("front:[");


        int size = array.getSize();
        for (int i = 0; i < size; i++) {
            builder.append(array.get(i));
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append("]tail");
        return builder.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if (i % 3 == 0) {
                System.out.println(arrayQueue.dequeue());
            }
            System.out.println(arrayQueue);
        }
    }
}
