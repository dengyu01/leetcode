package com.hsc.array;

public class Solution55 {
    public boolean canJump2(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        return Jump(nums, 0, visit);
    }

    public boolean Jump(int[] nums, int index, boolean[] visit) {
        if (index == nums.length - 1) {
            return true;
        }
        boolean res = false;
        for (int i = 1; i <= nums[index]; i ++) {
            if (index + i < nums.length && !visit[index + i]) {
                visit[index + i] = true;
                res = Jump(nums, index + i, visit);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
