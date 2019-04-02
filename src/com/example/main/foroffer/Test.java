package com.example.main.foroffer;

import java.util.StringJoiner;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * <p>
 * 例子说明：
 * <p>
 * 例如输入的数组为{1, -2, 3, 10, -4, 7, 2, -5}，和最大的子数组为｛3, 10, -4, 7, 2}。因此输出为该子数组的和18 。
 * 解题思路：
 * 我们试着从头到尾逐个累加示例数组中的每个数字。初始化和为0。第一步加上第一个数字1， 此时和为1。接下来第二步加上数字-2，和就变成了-1。第三步刷上数字3。我们注意到由于此前累计的和是－1 ，小于0，那如果用-1 加上3 ，得到的和是2 ， 比3 本身还小。也就是说从第一个数字开始的子数组的和会小于从第三个数字开始的子数组的和。因此我们不用考虑从第一个数字开始的子数组，之前累计的和也被抛弃。
 *
 * 我们从第三个数字重新开始累加，此时得到的和是3 。接下来第四步加10，得到和为13 。第五步加上-4， 和为9。我们发现由于-4 是一个负数，因此累加-4 之后得到的和比原来的和还要小。因此我们要把之前得到的和13 保存下来，它有可能是最大的子数组的和。第六步加上数字7，9 加7 的结果是16，此时和比之前最大的和13 还要大， 把最大的子数组的和由13更新为16。第七步加上2，累加得到的和为18，同时我们也要更新最大子数组的和。第八步加上最后一个数字-5，由于得到的和为13 ，小于此前最大的和18，因此最终最大的子数组的和为18 ，对应的子数组是｛3, 10, -4, 7, 2｝。
 */
public class Test {
    public static void main(String[] args) {
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(findGreatSumOfArray(array));
    }

    private static int findGreatSumOfArray(int[] array) {
        if (array == null || array.length < 1) {
            throw new IllegalArgumentException("输入的数组无效");
        }
        int max = Integer.MIN_VALUE;
        int curMax = max;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (curMax <= 0) {
                startIndex = i;
                endIndex = i;
                curMax = array[i];
            } else {
                curMax += array[i];
            }
            if (max < curMax) {
                max = curMax;
                endIndex = i;
            }
        }
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        for (int i = startIndex; i <= endIndex; i++) {
            joiner.add(String.valueOf(array[i]));
        }
        System.out.println(joiner.toString());

        return max;
    }
}
