package com.hsc.array;

import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num: nums) {
            sum += Math.abs(num - nums[nums.length / 2]);
        }
        return sum;
    }
}
