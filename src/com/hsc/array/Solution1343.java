package com.hsc.array;

public class Solution1343 {

    // 正确，时间复杂度高
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        for (int i = 0; i <= arr.length - k; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < i + k; j++) {
                sum += arr[j];
            }
            if (sum >= k * threshold) {
                res ++;
            }
        }
        return res;
    }
}
