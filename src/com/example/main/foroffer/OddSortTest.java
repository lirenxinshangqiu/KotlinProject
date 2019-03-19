package com.example.main.foroffer;

import java.util.StringJoiner;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分
 * 解题思路一：遍历数组，遇到奇数，向前插入偶数不变
 * 解题思路二：取两个指针，第一个指向0第二个指向末尾，如果两个指针不相等则比较两个值，如果第一个为偶第二个为奇数则交换，否则第一个++，第二个--
 */
public class OddSortTest {
    public static void main(String[] args) {
        sortArray(new int[]{1, 7, 4, 8, 3, 6, 9, 11});
        oddSortArray(new int[]{1, 7, 4, 8, 3, 6, 9, 11});
    }

    private static void oddSortArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        if (start == end) {
            printArray(array);
            return;
        }
        while (start != end) {
            int startE = array[start];
            int endE = array[end];
            if (startE % 2 == 0) {//为偶数
                if (endE % 2 == 1) {
                    change(start, end, array);
                    start++;
                }
                end--;
            } else {
                start++;
            }
        }
        printArray(array);
    }

    private static void change(int start, int end, int[] array) {
        if (start < 0 || start >= array.length || end < 0 || end >= array.length) return;
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

    }

    private static void sortArray(int[] array) {
        int index = 0;
        while (index < array.length) {
            //偶数位置不动，奇数位置向前插入
            if (array[index] % 2 == 0) {//偶数

            } else {//奇数
                int j = index;
                int tag = array[j];
                while (j > 0 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = tag;
            }
            index++;
        }
        printArray(array);
    }

    private static void printArray(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        System.out.println(stringJoiner.toString());
    }
}
