package com.example.main.foroffer;

import java.util.StringJoiner;

public class FindRepeatedNumberSolutation {
    public static void main(String[] args) {
        int[] array = new int[]{100, 121, 4433, 10000, 121, 10};
        System.out.println(findRepeatedNumber(array));
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 3, 4, 5, 6, 7};
        printArray(reverseMergeSortArray(a,b));

        Cat cat = new Cat();
        cat.testInstance();
        cat.testMethod();
        Animale animale  = cat;
        animale.testInstance();
        animale.testMethod();
    }

    private static int findRepeatedNumber(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int result = -1;
        int temp = array[0];
        for (int i = 1; i < array.length; i++) {
            temp ^=array[i];
        }

        return temp;
    }

    private static int[] reverseMergeSortArray(int[] a, int[] b) {
        if (a == null) {
            return reverseArray(b);
        }
        if (b == null) {
            return reverseArray(a);
        }

        int aStart = a.length - 1;
        int bStart = b.length - 1;
        int[] resultArray = new int[a.length + b.length];
        int index = 0;
        while (aStart >= 0 && bStart >= 0 && index >= 0) {
            if (a[aStart] > b[bStart]) {
                resultArray[index] = a[aStart];
                aStart--;
            } else if (a[aStart] < b[bStart]) {
                resultArray[index] = b[bStart];
                bStart--;
            } else {
                resultArray[index] = a[aStart];
                index++;
                resultArray[index] = b[bStart];
                aStart--;
                bStart--;
            }
            index++;
        }
        if (aStart>=0){//此时A中还有元素
           while (aStart>=0){
               resultArray[index] = a[aStart];
               index++;
               aStart--;
           }
        }
        if (bStart>=0){
            while (bStart>=0){
                resultArray[index] = b[bStart];
                index++;
                bStart--;
            }
        }

        return resultArray;
    }

    private static int[] reverseArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int start = 0;
        int end = array.length - 1;
        while (start >= 0 && start < end && end > 0) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }

    private static void printArray(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < array.length; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        System.out.println(stringJoiner.toString());
    }
}

class Animale{
    public  void testInstance(){
        System.out.println("testInstance in Animale");
    }

    public  void testMethod(){
        System.out.println("testMethod in Animale");
    }
}

class Cat extends Animale{
    public  void testInstance(){
        System.out.println("testInstance in cat");
    }

    public  void testMethod(){
        System.out.println("testMethod in cat");
    }
}
