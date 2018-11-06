package com.example.main;

/**
 * Created by ls on 18/6/26.
 */
public class SortDemo {

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length == 0) return;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        printArray(array, "冒泡排序");
    }

    /**
     * 改进的冒泡排序，如果数组有顺序，时间负责度为O(n)
     *
     * @param array
     * @param n
     */
    public static void bubbleSortImproved(int[] array, int n) {
        int pass, j, temp, swapped = 1;
        for (pass = n - 1; pass >= 0 && swapped == 1; pass--) {
            swapped = 0;
            for (j = 0; j < pass - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = 1;
                }
            }
        }

        printArray(array, "冒泡排序");
    }

    /**
     * 扩展性差
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length == 0) return;
        int temp, min, i, j;
        for (i = 0; i < length; i++) {
            min = i;
            for (j = i + 1; j < length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        printArray(array, "选择排序");
    }

    public static void fastSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length == 0) return;


    }

    public static void insertionSort(int[] array, int n) {
        int i, j, v;
        for (i = 2; i < n; i++) {
            v = array[i];
            j = i;
            while (j >= 1 && array[j - 1] > v) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
        }
        printArray(array, "插入排序");
    }


    private static void printArray(int[] array, String sortName) {
        System.out.println(sortName);
        System.out.print("[");
        int length = array.length;
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + (i == length - 1 ? "" : ","));
        }
        System.out.println("]");
    }

    public static int binarySearch(int[] array, int key) {
        int index = -1;
        int high = array.length - 1;
        int low = 0;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] == key) {
                index = middle;
                break;
            } else if (array[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return index;
    }
}
