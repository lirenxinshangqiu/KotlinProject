package com.example.main.book.stack

import com.example.main.datastructure.java.stack.ArrayStack

/**
 * 设计一个栈，是的getMInniMun()操作时间复杂度为O(1)
 * 设计一个辅助栈，保存原栈中所有元素的最小值，并且，假设辅助栈中每个元素的值逗比它下面的元素小，
 */
class AdavanceStack {
    private var elementStack: ArrayStack<Int> = ArrayStack()
    private var minStack: ArrayStack<Int> = ArrayStack()
    fun isEmpty(): Boolean = elementStack.isEmpty
    fun peek(): Int = elementStack.peek()
    fun pop(): Int {
        return if (elementStack.isEmpty) {
            -1
        } else {
            minStack.pop()
            elementStack.pop()
        }
    }

    fun push(data: Int) {
        elementStack.push(data)
        if (minStack.isEmpty || minStack.peek() >= data) {
            minStack.push(data)
        } else {
            minStack.push(minStack.peek())
        }
    }

    fun getMinMun(): Int = if (minStack.isEmpty) -1 else minStack.peek()
}

fun main(args: Array<String>) {
    val adavanceStack = AdavanceStack()
    adavanceStack.push(2)
    adavanceStack.push(6)
    adavanceStack.push(4)
    adavanceStack.push(1)
    adavanceStack.push(5)

    println(adavanceStack.getMinMun())
    adavanceStack.pop()
    println(adavanceStack.getMinMun())
    adavanceStack.pop()
    println(adavanceStack.getMinMun())
    adavanceStack.pop()
    println(adavanceStack.getMinMun())
    adavanceStack.pop()
    println(adavanceStack.getMinMun())
    adavanceStack.pop()

    val content = "abcbba"
    println("$content 是否是回文${isPalindrome(content)}")
}

/**
 * 给定一个字符串，判断该字符串是否是回文
 */
fun isPalindrome(content: String): Boolean {
    var i = 0
    var j = content.length - 1
    while (i < j && content[i] == content[j]) {
        i++
        j--
    }
    return i >= j
}