package com.example.main.datastructure.java.queue;

import com.example.main.User;
import com.example.main.datastructure.java.array.Array;

/**
 * 循环队列
 * Created by ls on 18/7/16.
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];//容量+1，为了区分队列满和队列空， front == tail 为空， （tail+1）%capacity == front 队列满
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if (isQueueFull()) {//队列满，需要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail+1)%data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    private boolean isQueueFull() {
        return (tail + 1) % data.length == front;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为null，不能出对");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为null，不能出对");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int length = getCapacity();
        builder.append(String.format("Queue:size = %1$d,capacity = %2$d \n", size, length));
        builder.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            builder.append(data[i]);
            if ((i + 1) % data.length != tail) {
                builder.append(", ");
            }
        }
        builder.append("]tail");
        return builder.toString();
    }
    public static void main(String[] args) {
        LoopQueue<Integer> arrayQueue = new LoopQueue<>();
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
