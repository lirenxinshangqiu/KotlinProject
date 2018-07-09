package com.example.main;

import java.util.Arrays;

/**
 * Created by ls on 18/7/2.
 */
public class BinaryTreeSolution {
    public static BinaryTreeNode constructCore(int[] preorder, int[] inorder) throws Exception {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new Exception("输入的长度不一致！");
        }
        BinaryTreeNode root = new BinaryTreeNode();
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                root.value = inorder[i];
                System.out.println(root.value);
                root.leftNode = constructCore(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.rightNode = constructCore(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }

    public static void printBinary(BinaryTreeNode root) {
        System.out.println(root);
        if (root == null) {
            System.out.println("二叉树为空");
            return;
        }


    }
}
