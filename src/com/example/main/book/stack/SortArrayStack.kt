package com.example.main.book.stack

import com.example.main.datastructure.java.stack.ArrayStack

fun main(args: Array<String>) {

    val arrayStack = ArrayStack<Int>()
    arrayStack.push(2)
    arrayStack.push(4)
    arrayStack.push(3)
    arrayStack.push(1)
    arrayStack.push(7)
    val stack = sort(arrayStack)
    println("arrayStack")
    printStack(arrayStack)
    println("stack")
    printStack(stack)
}

private fun printStack(stack: ArrayStack<Int>?) {
    stack?.apply {
        while (this.isEmpty.not()) {
            println(this.pop())
        }
    }
}

/**
 * 栈的升序排列算法
 */
private fun sort(stack: ArrayStack<Int>?): ArrayStack<Int>? {
    val arrayStack = ArrayStack<Int>()
    stack?.apply {
        while (this.isEmpty.not()) {
            val temp = this.pop()
            while (arrayStack.isEmpty.not() && arrayStack.peek() > temp) {
                this.push(arrayStack.pop())
            }
            arrayStack.push(temp)
        }
    }

    return arrayStack

}