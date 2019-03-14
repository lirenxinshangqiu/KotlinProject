package com.example.main.foroffer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建二叉树并输出它的头结点。
 *
 * 由前序遍历的第一个节点可知根节点。根据根节点，可以将中序遍历划分成左右子树。在前序遍历中找出对应的左右子树，其第一个节点便是根节点的左右子节点。按照上述方式递归便可重建二叉树。
 */
public class RebuildTreeTest {
    public static void main(String[] args) {
        int[] preArray = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] centerArray = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        prePrint(buildTree(preArray, centerArray));
    }

    private static TreeNode buildTree(int[] preArray, int[] centerArray) {
        if (preArray == null || preArray.length == 0 || centerArray == null || centerArray.length == 0 || preArray.length != centerArray.length) {
            return null;
        }
        return construct(preArray, 0, preArray.length - 1, centerArray, 0, preArray.length - 1);
    }

    private static TreeNode construct(int[] preArray, int indexS, int indexE, int[] centerArray, int indexCS, int indexCE) {
        if (indexS > indexE) return null;
        int root = preArray[indexS];

        int index = indexCS;
        while (index <= indexCE && centerArray[index] != root) {
            index++;
        }
        if (index > indexCE) {
            throw new IllegalArgumentException("数组不正确！");
        }
        TreeNode treeNode = new TreeNode();
        treeNode.value = root;
        //构建左子树，左子树元素个数，index-indexCS+1
        //左子树前序遍历位置在[indexS+1,indexS+index - indexCS]
        //左子树在中序遍历的位置在[indexCS,index-1]
        treeNode.leftNode = construct(preArray, indexS + 1, indexS + index - indexCS, centerArray, indexCS, index - 1);
        // 递归构建当前根结点的右子树，右子树的元素个数：indexE-index个
        // 右子树对应的前序遍历的位置在[indexS+index-indexCS+1, indexE]
        // 右子树对应的中序遍历的位置在[index+1, indexCE]
        treeNode.rightNode = construct(preArray, indexS + index - indexCS + 1, indexE, centerArray, index + 1, indexCE);
        return treeNode;
    }

    private static void prePrint(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value+" ");
        prePrint(node.leftNode);
        prePrint(node.rightNode);
    }
}

class TreeNode {
    public int value;
    public TreeNode leftNode;
    public TreeNode rightNode;

}


