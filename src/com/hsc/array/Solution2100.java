package com.hsc.array;

import java.util.ArrayList;
import java.util.List;

public class Solution2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int[] l = new int[security.length];
        int[] r = new int[security.length];
        for (int i = 1; i < security.length; i++) {
            if (security[i] <= security[i - 1]) {
                l[i] = l[i - 1] + 1;
            } else {
                l[i] = 0;
            }
        }
        for (int i = security.length - 2; i >= 0; i --) {
            if (security[i] >= security[i + 1]) {
                r[i] = r[i + 1] + 1;
            } else {
                r[i] = 0;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (l[i] >= time && r[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }
}
