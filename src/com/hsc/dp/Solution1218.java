package com.hsc.dp;

import java.util.HashMap;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        HashMap<Integer, Integer> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int pre = arr[i] - difference;
            int temp = dp.containsKey(pre)? dp.get(pre) + 1 : 1;
            dp.put(arr[i], temp);
            res = Math.max(temp, res);
        }
        return res;
    }
}
