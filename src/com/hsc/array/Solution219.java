package com.hsc.array;

import java.util.HashMap;

public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var table = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            if (table.containsKey(num)) {
                if (Math.abs(table.get(num) - i) <= k) {
                    return true;
                }
            }
            table.put(num, i);
        }
        return false;
    }
}
