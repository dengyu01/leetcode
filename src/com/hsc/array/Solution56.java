package com.hsc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {
    class Interval {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, Comparator.comparingInt(l -> l[0]));

        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.get(list.size() - 1).b) {
                list.get(list.size() - 1).b = Math.max(intervals[i][1], list.get(list.size() - 1).b);
            } else {
                list.add(new Interval(intervals[i][0], intervals[i][1]));
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);
            int[] ints = new int[2];
            ints[0] = interval.a;
            ints[1] = interval.b;
            res[i] = ints;
        }

        return res;
    }
}
