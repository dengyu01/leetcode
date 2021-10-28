package com.hsc.array;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int fiIndex = 0;
        int sum = 0;
        for (int i = 0; i < k; i ++) {
            sum += nums[i];
        }
        int i = k;
        int max = sum;
        while (i < nums.length) {
            sum -= nums[fiIndex++];
            sum += nums[i++];
            max = Math.max(max, sum);
        }
        return 1.0 * max / k;
    }
}
