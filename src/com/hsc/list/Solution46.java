package com.hsc.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        for (int num: nums) {
            temp.add(num);
        }
        backtrack(nums.length, temp, res, 0);
        return res;
    }

    private void backtrack(int n, List<Integer> temp,
                          List<List<Integer>> res, int first) {
        if (first == n) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = first; i < temp.size(); i ++) {
            Collections.swap(temp, first, i);
            backtrack(n, temp, res, i + 1);
            Collections.swap(temp, first, i);
        }
    }
}
