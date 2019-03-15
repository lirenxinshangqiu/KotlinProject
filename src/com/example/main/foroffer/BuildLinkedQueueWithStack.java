package com.example.main.foroffer;

import java.util.Stack;

public class BuildLinkedQueueWithStack {
    public static void main(String[] args) {

    }
}

/**
 * 用两个栈实现队列，并实现添加尾结点和删除头结点
 * @param <T>
 */
class Queue<T> {
    //只存储数据
    public Stack<T> stack1 = new Stack<>();
    //只弹出数据
    public Stack<T> stack2 = new Stack<>();

    public void add(T e) {
        stack1.push(e);
    }

    public T del() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new RuntimeException(" no more element.");
        }
        return stack2.pop();
    }

}


