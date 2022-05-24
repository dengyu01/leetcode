package com.hsc.array;

import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int first = 0; first < nums.length; first++) {

            int third = nums.length - 1;
            int rest = target - nums[first];


            for (int second = first + 1; second < nums.length; second++) {
                while (second < third) {
                    int re = Math.abs(rest - (nums[second] + nums[third]));
                    if (min > re) {
                        min = re;
                        res = nums[first] + nums[second] + nums[third];
                    }
                    if (second + 1 == third) {
                        break;
                    }
                    int lest = nums[second + 1] + nums[third];
                    int right = nums[second] + nums[third - 1];
                    if (Math.abs(rest - lest) < Math.abs(rest - right)) {
                        second ++;
                    } else {
                        third --;
                    }
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        solution16.threeSumClosest(new int[] {0,2,1,-3}, 1);
    }
}
