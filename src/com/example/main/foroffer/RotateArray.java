package com.example.main.foroffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾， 我们称之数组的旋转。输入一个递增排序的数组的一个旋转， 输出旋转数组的最小元素。例如数组{3,4,5,1,2 ｝为｛ 1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * 解题思路
 * **Step1.**和二分查找法一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。
 * <p>
 * **Step2.**接着我们可以找到数组中间的元素：
 * <p>
 * 如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素。此时数组中最小的元素应该位于该中间元素的后面。我们可以把第一个指针指向该中间元素，这样可以缩小寻找的范围。如果中间元素位于后面的递增子数组，那么它应该小于或者等于第二个指针指向的元素。此时该数组中最小的元素应该位于该中间元素的前面。
 * <p>
 * **Step3.**接下来我们再用更新之后的两个指针，重复做新一轮的查找。
 */
public class RotateArray {
    public static void main(String[] args) {
        System.out.println(min(new int[]{2, 3, 4, 5, 0, 1}));
        for (int i = 0; i <= 10; i++) {
            long n = i;
            System.out.println("f(" + n + ")=" + fabnic(n));
            System.out.println("f(" + n + ")=" + fabnic1(n));
        }
        System.out.println(calHex(9));
        System.out.println(calHex2(9));
        printMax(10);
    }

    private static void printMax(int n){
        long maxEnd = 1;
        for (int i = 0; i < n; i++) {
            maxEnd*=10;
        }
        for (long i = 1; i < maxEnd; i++) {
            System.out.println(i);
        }
    }
    private static int calHex(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }

    private static int calHex2(int n){
        int result = 0;
        while (n!=0){
            result++;
            n = (n-1) &n;
        }
        return result;
    }

    private static long fabnic(long n) {
        if (n == 0 || n == 1) return 1;
        return fabnic(n - 1) + fabnic(n - 2);
    }

    private static long fabnic1(long n) {
        if (n == 1 || n == 0) return 1;
        long sum1 = 1;//前第二个
        long sum2 = 1;//前第一个值
        long count = 2;
        long sum = 0;
        while (count <= n) {
            sum = sum1 + sum2;
            sum1 = sum2;
            sum2 = sum;
            count++;
        }
        return sum;
    }

    private static int min(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input invaleted");
        }

        int le = 0;
        int hi = array.length - 1;
        int index = le;
        while (array[le] >= array[hi]) {
            if (hi - le == 1) {
                return array[le];
            }
            index = le + (hi - le) / 2;
            if (array[index] == array[le] && array[index] == array[hi]) {
                return preOrder(array, le, hi);
            }
            if (array[index] >= array[le]) {
                le = index;
            }
            if (array[index] <= array[hi]) {
                hi = index;
            }
        }
        return array[index];
    }

    private static int preOrder(int[] array, int start, int end) {
        int result = array[start];
        for (int i = start + 1; i <= end; i++) {
            if (result > array[i]) {
                result = array[i];
            }
        }
        return result;
    }
}
