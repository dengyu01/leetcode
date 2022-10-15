package com.hsc.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> cur = new ArrayList<>();

        f(res, 0, nums, cur);
        return res;

    }

    public void f(List<List<Integer>> res, int index, int[] nums, List<Integer> cur) {
        if (index == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        f(res, index + 1, nums, cur);
        cur.add(nums[index]);
        f(res, index + 1, nums, cur);
        cur.remove(cur.size() - 1);
    }
}
