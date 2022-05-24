package com.hsc.array;

import java.util.*;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int target = -nums[first];
            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third --;
                }
                if (second >= third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    res.add(List.of(nums[first], nums[second], nums[third]));
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList<>();
        HashSet<String> strings = new HashSet<>();
        f(nums, 0, cur, res, strings);
        return res;
    }

    public void f(int[] nums, int i, List<Integer> cur, List<List<Integer>> res, HashSet<String> strings) {
        if (cur.size() == 3) {
            int sum = cur.get(0) + cur.get(1) + cur.get(2);
            if (sum == 0) {
                String key = String.valueOf(cur.get(0)) + String.valueOf(cur.get(1)) + String.valueOf(cur.get(2));
                if (!strings.contains(key)) {
                    res.add(new ArrayList<>(cur));
                    strings.add(key);
                }
            }
            return;
        }
        if (i == nums.length) {
            return;
        }
        cur.add(nums[i]);
        int index = cur.size() - 1;
        f(nums, i + 1, cur, res, strings);
        cur.remove(index);
        f(nums, i + 1, cur, res, strings);
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
