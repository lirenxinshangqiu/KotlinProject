package com.example.main.book.tree

import com.example.main.datastructure.java.queue.ArrayQueue
import com.example.main.datastructure.java.queue.Queue

/**
 * 二叉树相关问题
 */
fun main(args: Array<String>) {
    val rootTree = BinaryTreeNode()
    val firstTree = BinaryTreeNode()
    val secondTreeNode = BinaryTreeNode()
    val thirdTreeNode = BinaryTreeNode()
    val forthTreeNode = BinaryTreeNode()
    val fifthTreeNode = BinaryTreeNode()
    val sixthTreeNode = BinaryTreeNode()


    rootTree.data = 0
    firstTree.data = 1
    secondTreeNode.data = 2
    thirdTreeNode.data = 3
    forthTreeNode.data = 4
    fifthTreeNode.data = 5
    sixthTreeNode.data = 6
    firstTree.left = thirdTreeNode
    firstTree.right = forthTreeNode
    secondTreeNode.left = fifthTreeNode
    secondTreeNode.right = sixthTreeNode
    rootTree.left = firstTree
    rootTree.right = secondTreeNode
    println("数种的最大值：${findMax(rootTree)}")
    println("数种的最大值：${findMaxUseLeveOrder(rootTree)}")
    val findData = 5
    println("树中是否存在$findData：${rootTree.searchNode(findData)}")
    println("树中是否存在$findData：${rootTree.containElement(findData)}")
    rootTree.insert(sixthTreeNode)
    runMethod("插入一个节点：") {
        preOrder(rootTree)
    }
    println("节点数：${rootTree.size()}")
    println("节点数：${rootTree.sizeNonPre()}")
}

/**
 * 查找树中最大的节点
 */
fun findMax(treeNode: BinaryTreeNode?): Int {
    treeNode ?: return -1
    val left = findMax(treeNode.left)
    val right = findMax(treeNode.right)
    var max = Math.max(left, right)
    return Math.max(max, treeNode.data)
}

/**
 * 利用非递归方法查找树中最大值
 */
fun findMaxUseLeveOrder(treeNode: BinaryTreeNode?): Int {
    treeNode ?: return -1
    var max: Int = -1
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(treeNode)
    while (queue.isEmpty.not()) {
        var dequeue = queue.dequeue()
        val data = dequeue.data
        if (max < data) {
            max = data
        }
        if (dequeue.left != null) queue.enqueue(dequeue.left)
        if (dequeue.right != null) queue.enqueue(dequeue.right)
    }
    return max
}

/**
 * 查找树中是否存在某元素  递归
 */
fun BinaryTreeNode?.searchNode(data: Int): Boolean {
    this ?: return false
    if (this.data == data) {
        return true
    } else {
        val leftResult = this.left?.searchNode(data)
        if (leftResult == true) return true
        return this.right?.searchNode(data) == true
    }
}

/**
 * 非递归，层次遍历查找元素
 */
fun BinaryTreeNode?.containElement(data: Int): Boolean {
    this ?: return false
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(this)
    while (queue.isEmpty.not()) {
        val treeNode = queue.dequeue()
        if (data == treeNode.data) return true
        treeNode.left?.apply {
            queue.enqueue(this)
        }
        treeNode.right?.apply {
            queue.enqueue(this)
        }
    }
    return false
}

/**
 * 在子节点为null的节点插入节点
 */
fun BinaryTreeNode.insert(rootNode: BinaryTreeNode?) {
    rootNode ?: return
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(this)
    while (queue.isEmpty.not()) {
        var node = queue.dequeue()
        if (node.left == null) {
            node.left = rootNode
            return
        } else {
            queue.enqueue(node.left)
        }
        if (node.right == null) {
            node.right = rootNode
            return
        } else {
            queue.enqueue(node.right)
        }
    }
}

/**
 * 递归计算数的节点数
 */
fun BinaryTreeNode.size(): Int {
    return (this.left?.size() ?: 0) + 1 + (this.right?.size() ?: 0)
}

/**
 * 非递归计算节点数
 */
fun BinaryTreeNode.sizeNonPre(): Int {
    var count: Int = 1
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(this)
    while (queue.isEmpty.not()) {
        var treeNode = queue.dequeue()
        treeNode?.left?.apply {
            count++
            queue.enqueue(this)
        }
        treeNode?.right?.apply {
            count++
            queue.enqueue(this)
        }
    }
    return count
}

