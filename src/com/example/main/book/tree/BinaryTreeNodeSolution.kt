package com.example.main.book.tree

import com.example.main.datastructure.java.queue.ArrayQueue
import com.example.main.datastructure.java.queue.Queue
import java.util.*


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
    var count = 0
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(this)
    while (queue.isEmpty.not()) {
        var treeNode = queue.dequeue()
        treeNode?.left?.apply {
            queue.enqueue(this)
        }
        treeNode?.right?.apply {
            //            count++
            queue.enqueue(this)
        }
        count++
    }
    return count
}

fun delTree(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    var tempTreeNode = treeNode
    delTree(tempTreeNode.left)
    delTree(tempTreeNode.right)
    tempTreeNode = null
}

/**
 * 逆向逐层输出树中元素  输出-->6,5,4,3,2,1,0
 */
fun levelOrder(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(treeNode)
    val stack = Stack<BinaryTreeNode>()
    while (queue.isEmpty.not()) {
        var tree = queue.dequeue()
        tree.left?.apply {
            queue.enqueue(this)
        }
        tree.right?.apply {
            queue.enqueue(this)
        }
        stack.push(tree)
    }
    println()
    while (stack.empty().not()) {
        print("${stack.pop().data},")
    }
}

/**
 * 计算二叉树的高度
 */
fun height(binaryTreeNode: BinaryTreeNode?): Int {
    binaryTreeNode ?: return 0
    val leftHeight = height(binaryTreeNode.left)
    val rightHeight = height(binaryTreeNode.right)
    return if (leftHeight > rightHeight) leftHeight + 1 else rightHeight + 1
}

/**
 * 非递归计算树的高度
 */
fun BinaryTreeNode.heightLeve(): Int {
    var level = 0
    val queue = ArrayQueue<BinaryTreeNode>()
    queue.enqueue(this)
    queue.enqueue(null)
    while (queue.isEmpty.not()) {
        val rootNode = queue.dequeue()
        if (rootNode == null) {
            if (queue.isEmpty.not()) {
                queue.enqueue(null)
            }
            level++
        } else {
            rootNode.left?.apply {
                queue.enqueue(this)
            }
            rootNode.right?.apply {
                queue.enqueue(this)
            }

        }
    }
    return level
}



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
//    rootTree.insert(sixthTreeNode)
    runMethod("插入一个节点：") {
        preOrder(rootTree)
    }
    println("节点数：${rootTree.size()}")
    println("节点数：${rootTree.sizeNonPre()}")
    delTree(rootTree)
    println("节点数：${rootTree.size()}")
    levelOrder(treeNode = rootTree)
    println("层深：${rootTree.heightLeve()}")
    println("层深：${height(rootTree)}")
}
