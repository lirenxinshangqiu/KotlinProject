package com.example.main.datastructure.java.stack;

/**
 * Created by ls on 18/7/16.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
