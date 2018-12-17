package com.example.main.book.tree

import com.example.main.datastructure.java.stack.ArrayStack

class BinaryTreeNode {
    var data: Int = 0
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null


}

/**
 * 递归-先根遍历
 */
fun preOrder(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    println(treeNode.data)
    preOrder(treeNode.left)
    preOrder(treeNode.right)
}

/**
 * 递归-中根遍历
 */
fun centerOrder(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    centerOrder(treeNode.left)
    println(treeNode.data)
    centerOrder(treeNode.right)
}

/**
 * 递归-后跟遍历
 */
fun afterOrder(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    afterOrder(treeNode.left)
    afterOrder(treeNode.right)
    println(treeNode.data)
}

/**
 * 非递归-前根遍历
 */
fun preOrderNonRecursive(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    var tempTreeNode = treeNode
    val stack = ArrayStack<BinaryTreeNode>()
    while (true) {
        while (tempTreeNode != null) {
            println(tempTreeNode.data)
            stack.push(tempTreeNode)
            tempTreeNode = tempTreeNode.left
        }
        if (stack.isEmpty) break
        tempTreeNode = stack.pop()
        tempTreeNode = tempTreeNode?.right
    }

}

/**
 * 非递归-中序遍历
 */
fun centerOrderNonRecursive(treeNode: BinaryTreeNode?) {
    treeNode ?: return
    var tempTreeNode = treeNode
    val stack = ArrayStack<BinaryTreeNode>()
    while (true) {
        while (tempTreeNode != null) {
            stack.push(tempTreeNode)
            tempTreeNode = tempTreeNode.left
        }
        if (stack.isEmpty) {
            break
        }
        tempTreeNode = stack.pop()
        println(tempTreeNode.data)
        tempTreeNode = tempTreeNode.right
    }
}


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
    runMethod("递归前序遍历") { preOrder(rootTree) }
    runMethod("非递归前序遍历") { preOrderNonRecursive(rootTree) }
    runMethod("递归中根遍历") { centerOrder(rootTree) }
    runMethod("非递归中根遍历") { centerOrderNonRecursive(rootTree) }
    runMethod("递归后根遍历") { afterOrder(rootTree) }


}

inline fun runMethod(methodName: String = "", method: () -> Unit) {
    println(methodName)
    method()
}