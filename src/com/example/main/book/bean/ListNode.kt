package com.example.main.book.bean

/**
 * 单链表
 */
class ListNode {
    var data: Int = 0
    var next: ListNode? = null

    companion object {

        fun createListNode(array: Array<Int>, index: Int): ListNode? {
            if (array.isEmpty()) return null
            if (index >= array.size) return null
            val listNode = ListNode()
            listNode.data = array[index]
            listNode.next = createListNode(array, index + 1)
            return listNode
        }

        /**
         * 单链表的长度
         */
        fun listLength(listNode: ListNode?): Int {
            listNode ?: return 0
            var nextListNode = listNode
            var count = 0
            while (nextListNode != null) {
                count++
                nextListNode = nextListNode.next
            }
            return count
        }

        fun insertListNode(headNode: ListNode?, insertToListNode: ListNode?, position: Int): ListNode? {
            headNode ?: return insertToListNode
            isListNodeIlleagl(headNode, position)
            if (position == 0) {//插入头结点
                insertToListNode?.next = headNode
                return insertToListNode
            } else {
                var count = 1
                var nextNode = headNode
                while (count < position) {
                    nextNode = nextNode?.next
                    count++
                }
                insertToListNode?.next = nextNode?.next
                nextNode?.next = insertToListNode

            }
            return headNode
        }

        /**
         * 删除单链表中的元素
         */
        fun deleteNodeFromLinkedList(headNode: ListNode?, position: Int): ListNode? {
            isListNodeIlleagl(headNode, position)
            if (position == 0) {//删除头结点
                return headNode?.next
            } else {
                var preNode = headNode
                var count = 1
                while (count < position) {
                    preNode = preNode?.next
                    count++
                }
                var curNode = preNode?.next
                preNode?.next = curNode?.next
                curNode = null
            }
            return headNode

        }

        fun deleteLinkedList(headNode: ListNode?) {
            var auxilaryNode: ListNode? = null
            var iterator: ListNode? = headNode
            while (iterator != null) {
                auxilaryNode = iterator.next
                iterator = null
                iterator = auxilaryNode
            }
        }

        fun reserveLink(headNode: ListNode?):ListNode? {
            var curNode = headNode
            var preNode: ListNode? = null
            while (curNode != null) {
                var nextNode = curNode.next
                curNode.next = preNode
                preNode = curNode
                curNode = nextNode
            }
            return preNode
        }

        private fun isListNodeIlleagl(listNode: ListNode?, position: Int) {
            val length = listLength(listNode)
            if (position > length || position < 0) {
                throw IllegalArgumentException("输入的position不正确")
            }
        }
    }

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("[").append(data).append("->")
        var nextListNode = next
        while (nextListNode != null) {
            builder.append(nextListNode.data)
            nextListNode = nextListNode?.next
            nextListNode?.let {
                builder.append("->")
            }
        }
        builder.append("]")
        return builder.toString()
    }


}

fun main(args: Array<String>) {
    val listNode = ListNode.createListNode(arrayOf(1, 2, 3, 4, 5, 6), 0)
    println(listNode)
    println(ListNode.listLength(listNode))
    val insertListNode = ListNode()
    insertListNode.data = 7
    insertListNode.next = null
    val insertListNode1 = ListNode.insertListNode(listNode, insertListNode, 6)
    println(insertListNode1)
    ListNode.deleteNodeFromLinkedList(insertListNode1, 6)
    println(insertListNode1)
    ListNode.deleteLinkedList(insertListNode1)
    println(insertListNode1)
    val reserveLink = ListNode.reserveLink(listNode)
    println(reserveLink)
}