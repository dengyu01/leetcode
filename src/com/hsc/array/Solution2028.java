package com.hsc.array;

import java.util.Arrays;

public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = Arrays.stream(rolls).sum();
        int diff = mean * (m + n) - sum;
        if (diff < n || diff > n * 6) {
            return new int[0];
        }
        int[] res = new int[n];
        int a = diff / n;
        int b = diff % n;
        for (int i = 0; i < n; i++) {
            res[i] = a + (i < b ? 1 : 0);
        }
        return res;
    }
}
