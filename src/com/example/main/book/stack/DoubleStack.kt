package com.example.main.book.stack

import kotlin.properties.Delegates

/**
 * 只用一个数组实现两个栈，并保证只要数组中还有剩余空间，栈操作就不能提示异常
 */
class DoubleStack {
    private var size: Int = 10
    private var array: Array<Int?> by Delegates.notNull()
    private var top: Int = -1
    private var bottom: Int = size

    constructor(size: Int) {
        this.size = size
        if (size < 2) throw IllegalArgumentException("size大小不够用")
        array = Array<Int?>(size) { null }
    }

    fun push(stackId: Int, data: Int) {
        if (bottom == top + 1) throw IllegalArgumentException("Array is full")
        when (stackId) {
            1 -> array[++top] = data
            2 -> array[--bottom] = data
            else -> return
        }
    }


    fun pop(stackId: Int): Int? {
        return when (stackId) {
            1 -> {
                if (top == -1) throw IllegalArgumentException("first stack is Empty")
                val popData = array[top]
                array[top--] = null
                popData
            }
            2 -> {
                if (bottom == size) throw  IllegalArgumentException("second stack is Empty")
                val popData = array[bottom]
                array[bottom++] = null
                popData
            }
            else -> null
        }
    }

    fun top(stackId: Int): Int? {
        return when (stackId) {
            1 -> {
                if (top == -1) throw IllegalArgumentException("first stack is Empty")
                array[top]
            }
            2 -> {
                if (bottom == size) throw  IllegalArgumentException("second stack is Empty")
                array[bottom]
            }
            else -> null
        }
    }

    fun isEmpty(stackId: Int): Boolean {
        return when (stackId) {
            1 -> top == -1
            2 -> bottom == size
            else -> true
        }
    }
}