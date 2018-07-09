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

    public static void selectSort(int[] array) {
        if (array == null) {
            return;
        }
        int length = array.length;
        if (length == 0) return;
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = i + 1; j < length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
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
