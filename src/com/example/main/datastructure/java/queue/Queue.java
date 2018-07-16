package com.example.main.datastructure.java.queue;

/**
 * Created by ls on 18/7/16.
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
