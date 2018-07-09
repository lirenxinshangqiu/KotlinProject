package com.example.main;

import java.util.Arrays;

/**
 * Created by ls on 18/7/2.
 */
public class CardContinueSolution {
    public static boolean isContinue(int[] array) {
        if (array == null) {
            return false;
        }
        int zeorCount = 0;
        for (int i = 0; i < array.length && array[i] == 0; i++) {
            zeorCount++;
        }
        Arrays.sort(array);
        int gapNum = 0;
        for (int i = zeorCount; i < array.length - 1; i++) {
            if (array[i + 1] == array[i]) return false;
            gapNum += array[i + 1] - array[i] - 1;
        }
        return gapNum <= zeorCount;
    }
}
