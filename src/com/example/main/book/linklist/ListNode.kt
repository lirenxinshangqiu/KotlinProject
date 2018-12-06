package com.example.main.book.linklist

import com.sun.org.apache.xpath.internal.operations.Bool

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

        fun reserveLink(headNode: ListNode?): ListNode? {
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

/**
 * 蛮力法查找链表倒数第n个结点
 */
private fun searchByLastIndex(n: Int, listNode: ListNode?): ListNode? {
    listNode ?: return null
    var node = listNode
    var listLength = ListNode.listLength(node)
    if (n >= listLength) return null
    while (listLength > n) {
        node = node?.next
        listLength = ListNode.listLength(node)
    }

    return node
}

/**
 * 判断给定的链表是以NULL结点结束还是形成了环
 */
private fun doesLinkedListContainsLoop(headNode: ListNode?): Boolean {
    if (headNode == null) return false
    var slowNode: ListNode? = headNode
    var fastNode: ListNode? = headNode
    while (fastNode?.next != null && fastNode.next?.next != null) {
        fastNode = fastNode.next?.next
        slowNode = slowNode?.next
        if (fastNode == slowNode) return true
    }
    return false
}

/**
 * 一次扫描查找链表中倒数第n个结点
 */
private fun searcyByLastIndexWithOneScan(listNode: ListNode?, n: Int): ListNode? {
    var pTNode = listNode
    var nNode: ListNode? = null
    var count = 0
    while (pTNode != null) {
        count++
        pTNode = pTNode.next
        if (count >= n) {
            nNode = if (nNode == null) listNode else nNode.next
        }
    }
//    (1 .. n).forEach {
//        if (pTNode != null) {
//            pTNode = pTNode?.next
//        }
//    }
//    while (pTNode != null) {
//        pTNode = pTNode?.next
//        nNode = if (nNode == null) {
//            listNode?.next
//        } else {
//            nNode.next
//        }
//    }
    return nNode

}

fun main(args: Array<String>) {
    val listNode = ListNode.createListNode(arrayOf(1, 2, 3, 4, 5, 6), 0)
    println(searchByLastIndex(1, listNode))
    println(searcyByLastIndexWithOneScan(listNode, 5))
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