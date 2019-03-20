package com.example.main;

/**
 * Created by ls on 18/7/2.
 */
public class BinaryTreeNode {
    public  int value;
    public BinaryTreeNode leftNode;
    public BinaryTreeNode rightNode;

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
