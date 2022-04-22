package com.hsc.array;

import java.util.Arrays;

public class Solution396 {
    public int maxRotateFunction(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int f = 0;
        for (int i = 0; i < nums.length; i++) {
            f += i * nums[i];
        }
        int ans = f;
        for (int i = 1; i < nums.length; i++) {
            f = f + sum - nums.length * nums[nums.length - i];
            ans = Math.max(ans, f);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution396 solution396 = new Solution396();
        solution396.maxRotateFunction(new int[]{4, 3, 2, 6});
    }
}
