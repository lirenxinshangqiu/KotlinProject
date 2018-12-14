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
            val minPeek = minStack.peek()
            val peek = elementStack.peek()
            if (minPeek == peek) {
                println("minStack pop :$minPeek")
                minStack.pop()
            }
            elementStack.pop()
        }
    }

    fun push(data: Int) {
        elementStack.push(data)
        if (minStack.isEmpty || minStack.peek() >= data) {
            minStack.push(data)
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
    val inputContent = "abcXXcba"
    println("$content 是否是回文${isPalindrome(content)}")
    println("$inputContent 是否是回文${isPalindromeByStack(inputContent)}")

    val arrayStack = ArrayStack<Int>()
    (0..1).forEach { arrayStack.push(it) }
    reverseStack(arrayStack)

    (0..1).forEach { println(arrayStack.pop()) }

}

/**
 * 给定一个字符串，判断该字符串是否是回文
 * 从字符串两头开始遍历，如果相等头下标+1，尾下标-1，当循环结束，如果i<j则不是回文
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

/**
 * 用栈技术求解字符串回文问题
 * 只能解决一个X字符的回文问题
 */

fun isPalindromeByStack(content: String): Boolean {
    val toCharArray = content.toCharArray()
    val arrayStack = ArrayStack<Char>()
    var i = 0
    while (toCharArray[i] != 'X') {
        arrayStack.push(toCharArray[i])
        i++
    }
    i++
    while (i < toCharArray.size) {
        if (arrayStack.isEmpty) return false
        if (arrayStack.pop() != toCharArray[i]) return false
        i++
    }
    return true
}

/**
 * 给定一个栈，如何只使用栈操作（push和pop）逆置栈中的内容
 */
fun reverseStack(stack: ArrayStack<Int>) {
    if (stack.isEmpty) return
    val pop = stack.pop()
    reverseStack(stack)
    insertAtBottom(stack, pop)

}

fun insertAtBottom(stack: ArrayStack<Int>, data: Int) {
    if (stack.isEmpty) {
        stack.push(data)
        return
    }
    val temp = stack.pop()
    insertAtBottom(stack, data)
    stack.push(temp)
}
