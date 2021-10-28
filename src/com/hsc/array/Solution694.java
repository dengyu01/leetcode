package com.hsc.array;

import java.util.HashMap;
import java.util.Map;

public class Solution694 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> flag = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (flag.containsKey(nums[i])) {
                flag.get(nums[i])[0] ++;
                flag.get(nums[i])[2] = i;
            } else {
                flag.put(nums[i], new int[] {1, i, i});
            }
        }

        int max = 0, minLen = nums.length;
        for (Map.Entry<Integer, int[]> cur: flag.entrySet()) {
            int[] value = cur.getValue();
            if (max < value[0]) {
                max = value[0];
                minLen = value[2] - value[1] + 1;
            } else if (max == value[0]) {
                int i = value[2] - value[1] + 1;
                if (minLen > i) {
                    minLen = i;
                }
            }
        }
        return minLen;
    }
}
