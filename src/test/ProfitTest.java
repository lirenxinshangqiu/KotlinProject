package test;

import com.example.main.datastructure.java.leetcode.DelRepeatEmelemt;

/**
 * Created by ls on 18/7/17.
 */
public class ProfitTest {
    public static void main(String[]args){
        int[] prices = new int[]{7,1,5,3,6,4};
        DelRepeatEmelemt delRepeatEmelemt = new DelRepeatEmelemt();
        System.out.println(delRepeatEmelemt.maxProfit(prices));
    }
}
