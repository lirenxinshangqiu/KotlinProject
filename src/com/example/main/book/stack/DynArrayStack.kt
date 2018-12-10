package com.example.main.book.stack

class DynArrayStack {
    private var top: Int = -1
    private var capacity: Int = 1
    private var array = Array<Int>(capacity) { 0 }

    fun isEmpty() = top == -1

    fun isStackFull() = top == capacity - 1
    fun push(data: Int) {
        if (isStackFull()) {
            resize(capacity * 2)
        }
        array[++top] = data
    }

    fun pop(): Int {
        return if (isEmpty()) {
            println("Stack is Empty")
            0
        } else {
            if (top <= array.size / 4 && array.size / 2 != 0) {
                resize(array.size / 2)
            }
            array[top--]

        }
    }

    private fun resize(capacity: Int) {
        val newArray = Array<Int>(capacity) { 0 }
        System.arraycopy(array, 0, newArray, 0, if (this.capacity > capacity) capacity else this.capacity)
        this.capacity = capacity
        array = newArray
    }

    fun deleteStack() {
        top = -1
    }

}

fun main(args: Array<String>) {
    val stack = DynArrayStack()
    (0..10).forEach { stack.push(it) }
    (0..10).forEach {
        println(stack.pop())
    }

}