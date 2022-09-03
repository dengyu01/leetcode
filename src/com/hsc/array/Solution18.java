package com.hsc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
    // 需要考虑整形溢出问题
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        fourSum(nums, 0, target, res, cur);
        return res;
    }

    public void fourSum(int[] nums, int i, long target, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == 4 || i >= nums.length) {
            if (target == 0 && cur.size() == 4) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        int index = cur.size();
        cur.add(nums[i]);
        fourSum(nums, i + 1, target - nums[i], res, cur);
        cur.remove(index);

        int j = i + 1;
        while (j < nums.length && nums[j] == nums[i]) {
            j ++;
        }
        if (j < nums.length) {
            fourSum(nums, j, target, res, cur);
        }

    }
}
