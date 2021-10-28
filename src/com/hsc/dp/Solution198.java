package com.hsc.dp;

public class Solution198 {
    public int rob2(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0) {
            return 0;
        }
        dp[0] = nums[0];
        if (nums.length > 1) {
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for (int i = 2; i < nums.length; i ++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public int rob(int[] nums) {
        int cur1, cur2 = 0, ans;
        if (nums.length == 0) {
            return 0;
        }
        cur1 = nums[0];
        if (nums.length > 1) {
            cur2 = Math.max(nums[0], nums[1]);
        }
        ans = Math.max(cur1, cur2);
        for (int i = 2; i < nums.length; i ++) {
            ans = Math.max(cur1 + nums[i], cur2);
            cur1 = cur2;
            cur2 = ans;
        }
        return ans;
    }

    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
