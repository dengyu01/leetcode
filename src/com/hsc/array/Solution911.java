package com.hsc.array;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution911 {
    private final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public Solution911(int[] persons, int[] times) {
        HashMap<Integer, Integer> statistic = new HashMap<>();
        int curMaxPeople = -1;
        int max = 0;
        for (int i = 0; i < times.length; i++) {
            int curPerson = persons[i];
            int curStatistic = statistic.containsKey(curPerson)?
                    statistic.get(curPerson) + 1 : 1;
            statistic.put(curPerson, curStatistic);
            if (curStatistic > max) {
                max = curStatistic;
                curMaxPeople = persons[i];
            }
            map.put(times[i], curMaxPeople);
        }
    }

    public int q(int t) {
        if (map.containsKey(t)) {
            return map.get(t);
        }
        Object[] key = map.keySet().toArray();
        int lo = 0, hi = key.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((int)key[mid] <= t) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return map.get(key[lo - 1]);
    }
}
