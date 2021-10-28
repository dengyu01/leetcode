package com.hsc.other;

import java.util.HashMap;

public class Solution343 {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public int integerBreak2(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 2; i < n; i++) {
            int sub2 = f1(n - i);
            max = Math.max(max, i * sub2);
        }
        return max;
    }

    public int f1(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            int sub = Math.max(key, integerBreak(key));
            map.put(key, sub);
            return sub;
        }
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();
        int i = solution343.integerBreak(10);
        System.out.println(i);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(i * (j - i), i * dp[j - i]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
