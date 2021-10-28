package com.hsc.dp;

public class Solution152 {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int m = max, n = min;
            // f(i)只依赖f(i-1)，max保存的并不是全局最大值，而是乘以nums[i-1]中的最大值。
            max = Math.max(m * nums[i], Math.max(n * nums[i], nums[i]));
            min = Math.min(m * nums[i], Math.min(n * nums[i], nums[i]));
            // 和之前算出的最大值做比较
            ans = Math.max(ans, max);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution152 solution152 = new Solution152();
        solution152.maxProduct(new int[] {-3, -4, -2});
    }
}
