package com.example.main.book.tree

class BinaryTreeNode {
    var data: Int = 0
    var left: BinaryTreeNode? = null
    var right: BinaryTreeNode? = null


}

fun preOrder(treeNode: BinaryTreeNode?){
    treeNode?:return
    println(treeNode.data)
    preOrder(treeNode.left)
    preOrder(treeNode.right)
}

fun preOrderNonRecursive(treeNode: BinaryTreeNode?){
    treeNode?:return

}

fun main(args: Array<String>) {

}