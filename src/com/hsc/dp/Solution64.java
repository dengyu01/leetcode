package com.hsc.dp;

public class Solution64 {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i ++) {
            if (i == 0) {
                dp[i] = grid[0][0];
            } else {
                dp[i] = dp[i - 1] + grid[0][i];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}
