package com.hsc.array;

public class Solution11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = Math.min(height[r], height[l]) * (r - l);
            max = Math.max(max, area);
            if (height[l] <= height[r]) {
                l ++;
            } else {
                r --;
            }
        }
        return max;
    }
}
