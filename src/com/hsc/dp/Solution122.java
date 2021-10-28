package com.hsc.dp;

public class Solution122 {
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public int maxProfit(int[] prices) {
        int out = 0;
        int in = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            out = Math.max(out, in + prices[i]);
            in = Math.max(in, out - prices[i]);
        }
        return out;
    }
}
