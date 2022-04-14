package com.hsc.other;

import java.util.Arrays;

public class Solution1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] a: accounts) {
            int sum = Arrays.stream(a).sum();
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
