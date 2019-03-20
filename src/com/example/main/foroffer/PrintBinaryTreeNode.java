package com.example.main.foroffer;

import com.example.main.BinaryTreeNode;
import com.example.main.datastructure.java.queue.LinkedListQueue;

/**
 *
 从上往下打印出二叉树的每个结点，同一层的结点按照从左向右的顺序打印。


 这道题实质是考查树的遍历算法。从上到下打印二叉树的规律：每一次打印一个结点的时候，如果该结点有子结点， 则把该结点的子结点放到一个队列的末尾。接下来到队列的头部取出最早进入队列的结点，重复前面的打印操作，直至队列中所有的结点都被打印出来为止。
 */
public class PrintBinaryTreeNode {
    public static void main(String[] args) {

    }

    private static void printBinaryTreeNode(BinaryTreeNode node){
        if (node == null) {
            return;
        }
        LinkedListQueue<BinaryTreeNode> list = new LinkedListQueue<>();
        list.enqueue(node);
        BinaryTreeNode cur ;
        while (!list.isEmpty()){
            cur = list.dequeue();
            System.out.println(cur.value);
            if (cur.leftNode != null) {
                list.equals(cur.leftNode);
            }
            if (cur.rightNode != null) {
                list.equals(cur.rightNode);
            }
        }
    }

}
