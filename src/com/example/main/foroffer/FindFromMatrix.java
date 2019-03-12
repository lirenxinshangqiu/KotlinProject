package com.example.main.foroffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 思路：
 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束。
 *
 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
 *
 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
 */
public class FindFromMatrix {
    public static void main(String[] args) {
        int[][] matrix = getMatrix(0, 5, 5);
        printMatrix(matrix);
        System.out.println(find(15,matrix));
    }

    private static int[][] getMatrix(int start, int row, int clown) {
        int[][] matrix = new int[row][clown];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < clown; j++) {
                matrix[i][j] = start + i + j;
            }
        }
        return matrix;
    }


    private static boolean find(int target,int[][]matrix){
        if (matrix == null || matrix.length<1 || matrix[0].length<1) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols-1;
        while (row>=0 && row<rows && col>=0 && col<cols){
            if (matrix[row][col] == target){//从右上角开始判断，如果刚好相等则结束
                return true;
            }else if (matrix[row][col] > target){//如果数组中的值大于目标值，去掉该列，因为该列中的值都大于目标值
                col--;
            }else {//如果小于目标值，去掉该行
                row++;
            }
        }
        return false;
    }

    private static void printMatrix(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            int clown = matrix[i].length;
            for (int j = 0; j < clown; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
