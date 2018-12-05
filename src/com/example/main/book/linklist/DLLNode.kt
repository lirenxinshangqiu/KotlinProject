package com.example.main.book.linklist

/**
 * 双向链表
 */
class DLLNode {
    var data: Int = 0
    var next: DLLNode? = null
    var previous: DLLNode? = null

    companion object {
        fun createDLLNode(array: Array<Int>, index: Int, preNode: DLLNode?): DLLNode? {
            if (array.isEmpty()) return null
            if (index < 0 || index >= array.size) return null
            val dllNode = DLLNode()
            dllNode.data = array[index]
            dllNode.previous = preNode
            dllNode.next = createDLLNode(array, index + 1, dllNode)
            return dllNode

        }

        fun getLength(node: DLLNode?): Int {
            var count = 0
            var currentNode: DLLNode? = node
            while (currentNode != null) {
                currentNode = currentNode.next
                count++
            }
            return count
        }

        fun dllInsert(headNode: DLLNode?, nodeToInsert: DLLNode?, position: Int): DLLNode? {
            headNode ?: return nodeToInsert
            val size = getLength(headNode)
            if (position > size || position < 0) {
                println("position不能超过链表长度或者小于0")
            }
            if (position == 0) {//头结点处插入结点
                nodeToInsert?.next = headNode
                headNode.previous = nodeToInsert
                return nodeToInsert
            } else {
                var preNode = headNode
                var count = 1
                while (count < position) {
                    preNode = preNode?.next
                    count++
                }
                var curNode = preNode?.next
                nodeToInsert?.next = curNode
                curNode?.previous = nodeToInsert
                preNode?.next = nodeToInsert
                nodeToInsert?.previous = preNode
                return headNode
            }
        }

    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("[").append("null").append("<==>").append(data).append("<==>")
        var nextDLLNode: DLLNode? = next
        while (nextDLLNode != null) {
            builder.append(nextDLLNode.data)
            nextDLLNode = nextDLLNode?.next
            builder.append("<==>")
        }
        builder.append("null").append("]")

        return builder.toString()
    }


}

fun main(args: Array<String>) {
    val listNode = DLLNode.createDLLNode(arrayOf(0, 1, 2, 3, 4, 5, 6), 0, null)
    println(listNode)
    val dllNode = DLLNode()
    dllNode.data = 10
    println(DLLNode.dllInsert(listNode,dllNode,7))
}