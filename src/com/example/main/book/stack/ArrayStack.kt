package com.example.main.book.stack

class ArrayStack {
    private var top: Int = -1
    private var capacity: Int = 1
    private var array: Array<Int> = Array<Int>(capacity, init = { it * 0 })


    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isStackFull(): Boolean {
        return top == capacity - 1
    }

    fun push(data: Int) {
        if (isStackFull()) println("Stack Overflow")
        else {
            array[++top] = data
        }
    }

    fun pop(): Int {
        return if (isEmpty()) {
            println("Stack is Empty")
            0
        } else {
            array[top--]
        }
    }

    fun deleteStack() {
        top = -1
    }
}