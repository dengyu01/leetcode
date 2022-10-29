package com.hsc.other;

import java.util.HashSet;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                continue;
            }
            int curNum = nums[i];
            int num = 0;
            while (set.contains(curNum)) {
                curNum ++;
                num ++;
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
