package com.hsc.dp;

import java.util.Arrays;

public class Solution213 {
//    public int rob(int[] nums) {
//        if (null == nums || nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        return Math.max(f(nums, 1, nums.length), f(nums, 0, nums.length- 1));
//    }
//
//    private int f(int[] nums, int l, int r) {
//        if (l + 1 == nums.length) {
//            return nums[l];
//        }
//        int yes, to, ans;
//        yes = nums[l];
//        ans = to = Math.max(nums[l], nums[l + 1]);
//        for (int i = l + 2; i < r; i ++) {
//            ans = Math.max(yes + nums[i], to);
//            yes = to;
//            to = ans;
//        }
//        return ans;
//    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, ans = 0;
        for(int num : nums) {
            ans = Math.max(pre + num, cur);
            pre = cur;
            cur = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        solution213.rob(new int[] {2,7,9,3,1});
    }
}
