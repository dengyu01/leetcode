package com.hsc.stackandqueue;

import java.util.ArrayList;
import java.util.List;

public class Solution1441 {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        int num = 1;
        while (i < target.length && num <= n) {
            if (target[i] == num) {
                res.add("Push");
                i ++;
            } else {
                res.add("Push");
                res.add("Pop");
            }
            num ++;
        }
        return res;
    }
}
