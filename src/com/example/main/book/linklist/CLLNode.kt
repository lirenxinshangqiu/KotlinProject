package com.example.main.book.linklist

class CLLNode {
    var data: Int = 0
    var nextNode: CLLNode? = null
    var preNode: CLLNode? = null

}

/**
 * 计算循环链表长度
 */
fun circularListLength(headNode: CLLNode?): Int {
    var length = 0
    var currentNode = headNode
    while (currentNode != null) {
        length++
        currentNode = currentNode.nextNode
        if (headNode == currentNode) break
    }
    return length
}