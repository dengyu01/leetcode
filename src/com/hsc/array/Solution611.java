package com.hsc.array;

import java.util.Arrays;

public class Solution611 {
    public int triangleNumber(int[] nums) {
        int len = nums.length, res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len -1; j++) {
                int lo = j + 1, hi = len - 1, k = j;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        k = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                res += k - j;
            }
        }
        return res;
    }
}
