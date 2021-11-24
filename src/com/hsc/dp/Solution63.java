package com.hsc.dp;

public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i ++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i ++) {
            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }
            for (int j = 1; j < obstacleGrid[i].length; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }
}
