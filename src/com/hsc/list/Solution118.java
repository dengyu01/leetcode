package com.hsc.list;

import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> preLineList = new ArrayList<>();

        for (int i = 0; i < numRows; i ++) {
            if (i > 0) {
               preLineList = res.get(i - 1);
            }
            ArrayList<Integer> curLineList = new ArrayList<>(i + 1);
            curLineList.add(1);
            for (int j = 1; j < i; j ++) {
                int cur = preLineList.get(j - 1) + preLineList.get(j);
                curLineList.add(cur);
            }
            if (i > 0) {
                curLineList.add(1);
            }
            res.add(curLineList);
        }
        return res;
    }
}
