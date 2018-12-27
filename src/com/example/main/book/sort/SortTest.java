package com.example.main.book.sort;

public class SortTest {
    public static void main(String args[]) {
        int[] array = new int[]{8, 5, 6, 3, 7, 2, 9, 4};
//        bubbleSortImprove(array);
//        selectSort(array);
        insertationSort(array);
        printArray(array);
//        System.out.println();
//        bubbleSort(array);
//
//        printArray(array);

    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubbleSort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序改良版
     *
     * @param array
     */
    private static void bubbleSortImprove(int array[]) {
        boolean isSwap = true;
        for (int i = 0; i < array.length && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSwap = true;
                }
            }
        }
    }

    /**
     * 选择排序
     *
     * @param array
     */
    public static void selectSort(int array[]) {
        if (array == null || array.length == 0) return;
        int i, j, temp, min;
        for (i = 0; i < array.length - 1; i++) {
            min = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    public static void insertationSort(int array[]) {
        if (array == null || array.length == 0) return;
//8, 5, 6, 3, 7, 2, 9, 4
        for (int index = 1; index < array.length; index++) {
            int temp = array[index];
            int leftIndex = index - 1;
            while (leftIndex >= 0 && array[leftIndex] > temp) {
                array[leftIndex + 1] = array[leftIndex];
                leftIndex--;
            }
            array[leftIndex + 1] = temp;
        }
    }

    private static void printArray(int array[]) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) System.out.print(",");
        }
        System.out.print("]");
    }

}
