package com.hsc.other;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> res = new ArrayList<>(rowIndex + 1);
        res.add(1);
        for (int i = 1; i <= rowIndex; i ++) {
            int temp = 1;
            for (int j = 1; j < i; j ++ ) {
                int nextVal = temp + res.get(j);
                temp = res.get(j);
                res.set(j, nextVal);
            }
            res.add(1);
        }
        return res;
    }
}
