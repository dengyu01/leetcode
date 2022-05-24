package com.hsc.array;

import java.util.Arrays;

public class Solution31 {
    public void nextPermutation2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = 1;
        int last = -1;
        int temp = -1;
        while (i < nums.length) {
            if (nums[i] >= nums[i - 1]) {
                last = i - 1;
                temp = i;
            } else if (last != -1 && nums[i] >= nums[last]) {
                temp = i;
            }
            i ++;
        }
        if (temp != -1) {
            int t = nums[temp];
            while (temp > last) {
                nums[temp] = nums[temp - 1];
                temp --;
            }
            nums[temp] = t;
        } else {
            Arrays.sort(nums);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        int i = -1;

        int left = nums.length - 1;
        while (left > 0 && nums[left] <= nums[left - 1]) {
            left --;
        }
        int right = nums.length - 1;
        if (left > 0) {
            i = left - 1;
            while (right > i && nums[i] >= nums[right]) {
                right --;
            }
            int temp = nums[right];
            nums[right] = nums[i];
            nums[i] = temp;
        }

        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l ++;
            r --;
        }

    }
}
