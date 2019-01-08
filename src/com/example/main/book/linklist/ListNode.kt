package com.example.main.book.linklist

import com.sun.org.apache.xpath.internal.operations.Bool
import kotlin.math.abs

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
 * 如果链表中存在环，判断环的起点,
 * 第一次相遇后，慢的结点指针指向头结点，快结点指针不变，速度和慢结点一样，然后再次相遇的时候就是圆环的起始点
 */
private fun findBeginLoop(headNode: ListNode?): Int {
    var hasLoop: Boolean = false
    if (headNode == null) {
        hasLoop = false
    }
    var slowNode: ListNode? = headNode
    var fastNode: ListNode? = headNode
    while (fastNode?.next != null && fastNode.next?.next != null) {
        fastNode = fastNode.next?.next
        slowNode = slowNode?.next
        if (fastNode == slowNode) {
            hasLoop = true
            break
        }
    }
    return if (hasLoop) {
        var count = 0
        slowNode = headNode
        while (slowNode != fastNode) {
            slowNode = slowNode?.next
            fastNode = fastNode?.next
            count++
        }
        count
    } else {
        -1
    }
}

/**
 * 计算环的长度，找到环中第一次相遇的点后，快结点指针不变，慢结点继续向前移动，直到两个结点再次相遇
 */
private fun calLoopLength(listNode: ListNode?): Int {
    listNode ?: return 0
    var slowNode: ListNode? = listNode
    var fastNode: ListNode? = listNode
    var hasLoop = false
    while (fastNode?.next != null && fastNode.next?.next != null) {
        fastNode = fastNode.next?.next
        slowNode = slowNode?.next
        if (fastNode == slowNode) {
            hasLoop = true
            break
        }
    }
    return if (hasLoop) {
        var count = 0
        slowNode = slowNode?.next
        while (slowNode != fastNode) {
            count++
            slowNode = slowNode?.next
        }
        return count
    } else {
        0
    }
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

/**
 * 翻转单链表
 */
private fun reverseListNode(headNode: ListNode?): ListNode? {
    headNode ?: return null
    var head: ListNode? = headNode
    var temp: ListNode? = null
    var nextNode: ListNode? = null
    while (head != null) {
        nextNode = head.next
        nextNode?.next = temp
        temp = head
        head = nextNode
    }
    return head
}

/**
 * 迭代方法实现单链表翻转
 */
private fun reverseListNode2(headNode: ListNode?,prevNode: ListNode?):ListNode?{
    return if (headNode?.next ==null){
        headNode?.next = prevNode
        headNode
    }else{
        val re = reverseListNode2(headNode.next, headNode)
        headNode.next = prevNode
        re
    }
}

private fun printListFromEnd(head: ListNode?) {
    head?.apply {
        printListFromEnd(head.next)
        println(head.data)
    }
}

/**
 * 合并两个有序单链表，合并之后也是有序的，此方法包括去重，合并之后没有重复元素
 */
private fun mergeList(a: ListNode?, b: ListNode?): ListNode? {
    var aNode: ListNode? = a
    var bNode: ListNode? = b

    aNode ?: return bNode
    bNode ?: return aNode
    var result: ListNode? = null
    if (aNode.next != null && aNode.data == aNode.next?.data) {
        aNode.next = aNode.next?.next
    }
    if (bNode.next != null && bNode.data == bNode.next?.data) {
        bNode.next = bNode.next?.next
    }
    when {
        aNode.data < bNode.data -> {
            result = aNode
            result.next = mergeList(aNode.next, bNode)
        }
        aNode.data > bNode.data -> {
            result = bNode
            result.next = mergeList(bNode.next, aNode)
        }
        else -> {
            aNode.next = mergeList(aNode.next, bNode.next)
            bNode.next = mergeList(bNode.next, aNode.next)
            result = aNode
            result.next = mergeList(aNode.next, bNode.next)
        }
    }
    return result
}

/**
 * 如何逐对逆置链表？例如初始链表为1->2->3->4->X，那么经过逐对逆置后，新链表应该变为2->1->4->3->X
 * 递归版本
 */
private fun reversePairRecursive(headNode: ListNode?): ListNode? {
    var head: ListNode? = headNode
    var temp: ListNode? = null
    return if (head?.next == null) {
        head
    } else {
        temp = head.next
        head.next = temp?.next
        temp?.next = head
        head = temp
        head?.next?.next = reversePairRecursive(head?.next?.next)
        head
    }

}

/**
 * 如何逐对逆置链表？例如初始链表为1->2->3->4->X，那么经过逐对逆置后，新链表应该变为2->1->4->3->X
 * 迭代版本
 */

private fun reversePairIterative(headNode: ListNode?): ListNode? {
    var head: ListNode? = headNode
    var temp1: ListNode? = null
    var temp2: ListNode? = null
    while (head?.next != null) {
        if (temp1 != null) {
            temp1.next?.next = head.next
        }
        temp1 = head.next
        head.next = head.next?.next
        temp1?.next = head
        if (temp2 == null) {
            temp2 = temp1
        }
        head = head?.next
    }
    return temp2
}

fun main(args: Array<String>) {
    val listNode = ListNode.createListNode(arrayOf(1, 2, 3, 4, 5, 6, 7), 0)
    val listNode1 = ListNode.createListNode(arrayOf(3, 4, 5, 6, 7, 9), 0)

    println(reversePairRecursive(listNode))
    println(reversePairIterative(listNode))
    println(mergeList(listNode, listNode1))
    println(printListFromEnd(listNode))
    println(searchByLastIndex(1, listNode))
    println(searcyByLastIndexWithOneScan(listNode, 5))
    println(listNode)
    println(ListNode.listLength(listNode))
    val insertListNode = ListNode()
    insertListNode.data = 7
    insertListNode.next = null
//    val insertListNode1 = ListNode.insertListNode(listNode, insertListNode, 6)
//    println(insertListNode1)
//    ListNode.deleteNodeFromLinkedList(insertListNode1, 6)
//    println(insertListNode1)
//    ListNode.deleteLinkedList(insertListNode1)
//    println(insertListNode1)
//    val reserveLink = ListNode.reserveLink(listNode)
//    println(reserveLink)
}