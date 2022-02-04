package com.hsc.array;

public class Solution1725 {
    public int countGoodRectangles(int[][] rectangles) {
        int maxLen = Integer.MIN_VALUE;
        int num = 0;
        for (int i = 0; i < rectangles.length; i++) {
            int curMax = Math.min(rectangles[i][0], rectangles[i][1]);
            if (curMax > maxLen) {
                maxLen = curMax;
                num = 1;
            } else if (curMax == maxLen) {
                num ++;
            }
        }
        return num;
    }
}
