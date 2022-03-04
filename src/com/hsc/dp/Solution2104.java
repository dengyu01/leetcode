package com.hsc.dp;

public class Solution2104 {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[][] min = new long[n][n];
        long[][] max = new long[n][n];
        for (int i = 0; i < nums.length; i++) {
            min[i][i] = nums[i];
            max[i][i] = nums[i];
        }
        long res = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                min[i][j] = Math.min(nums[j], min[i][j - 1]);
                max[i][j] = Math.max(nums[j], max[i][j - 1]);
                res += max[i][j] - min[i][j];
            }
        }
        return res;
    }
}
