package com.hsc.dp;

import java.util.Arrays;

/**
 * 超出时间限制。。。
 */
public class Solution312 {
    public int maxCoins(int[] nums) {
        int[] curFlag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            curFlag[i] = 0;
        }
        return maxCoins(nums, curFlag);
    }

    public int maxCoins(int[] nums, int[] flag) {
        int max = 0;
        for (int i = 0; i < flag.length; i ++) {
            if (flag[i] == 0) {
                int[] curFlag = Arrays.copyOf(flag, flag.length);
                curFlag[i] = 1;
                int cur = nums[i] * getLAndR(nums, curFlag, i) + maxCoins(nums, curFlag);
                max = Math.max(cur, max);
            }
        }
        return max;
    }

    public int getLAndR(int[] nums, int[] flag, int index) {
        int res = 1;
        int l = index - 1;
        while (l >= 0 && flag[l] == 1) {
            l --;
        }
        if (l >= 0) {
            res *= nums[l];
        }

        int r = index + 1;
        while (r < nums.length && flag[r] == 1) {
            r ++;
        }
        if (r < nums.length) {
            res *= nums[r];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        int res = solution312.maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(res);
    }
}
