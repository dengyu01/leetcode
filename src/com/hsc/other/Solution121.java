package com.hsc.other;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int curMax = 0;
        int curP = 0;
        for (int price : prices) {
            if (price < curMin) {
                curMax = 0;
                curMin = price;
            } else if (price > curMax) {
                curMax = price;
            }
            if (curMax - curMin > curP) {
                curP = curMax - curMin;
            }
        }
        return curP;
    }

    public static void main(String[] args) {
        int[] test = new int[] {7,1,5,3,6,4};
        Solution121 solution = new Solution121();
        int i = solution.maxProfit(test);
        System.out.println(i);
    }
}
