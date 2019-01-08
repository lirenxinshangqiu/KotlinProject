package test;

import com.example.main.datastructure.java.leetcode.DelRepeatEmelemt;

/**
 * Created by ls on 18/7/17.
 */
public class ProfitTest {
    public static void main(String[]args){
        int[] prices = new int[]{7,6,1,5,3,3,6,5,4};
        DelRepeatEmelemt delRepeatEmelemt = new DelRepeatEmelemt();
        int index = delRepeatEmelemt.removeDuplicates(prices);
        for (int price : prices) {
            System.out.println(price);
        }
        System.out.println(delRepeatEmelemt.maxProfit(prices));
    }
}
