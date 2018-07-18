package com.example.main.datastructure.java.leetcode;

/**
 * Created by ls on 18/7/17.
 */
public class DelRepeatEmelemt {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != (nums[i + 1])) {
                index++;
                nums[index] = nums[i + 1];
            }
        }
        return index + 1;

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                int profit = prices[j] - price;
                if (maxProfit< profit){
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }
}
