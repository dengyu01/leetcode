package com.hsc.dp;

import java.util.HashMap;
import java.util.HashSet;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        var dp = new HashMap<Integer, Boolean>();
        var arr = new HashMap<Integer, HashSet<Integer>>();
        for(int i = 0; i < 10; i ++) {
            dp.put(i, true);
            var set = new HashSet<Integer>();
            set.add(i);
            arr.put(i, set);
        }
        int c = 10;
        for(int i = 2; i <= n ; i ++) {
            int start = (int) Math.pow(10, i - 1);
            int end = (int) Math.pow(10, i);
            for (int j = start; j < end; j ++) {
                int high = j / c;
                int last = j - high * c;
                if (last == 0 && i > 2) {
                    continue;
                }
                if (dp.containsKey(last)) {
                    if (!arr.get(last).contains(high)) {
                        var set2 = arr.get(last);
                        var set3 = new HashSet<Integer>(set2);
                        dp.put(j, true);
                        set3.add(high);
                        arr.put(j, set3);
                    }
                }
            }
            c = c * 10;
        }
        return dp.size();
    }
}
