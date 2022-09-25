package com.hsc.array;

public class Solution75 {
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i < right && nums[i] == 2) {
                change(nums, i, right);
                right --;
            }
            if (nums[i] == 0) {
                change(nums, i, left);
                left ++;
            }
        }
    }

    public void change(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
