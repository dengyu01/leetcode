package com.hsc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1748 {
    public int sumOfUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        Arrays.stream(nums).forEach(num -> {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        });
        return map.entrySet().stream().filter(val -> val.getValue() == 1)
                .map(Map.Entry::getKey).reduce(0, Integer::sum);
    }
}
