package com.hsc.array;

public class Solution_0803 {
    public int findMagicIndex(int[] nums) {
        int index = 0;
        while (index < nums.length && nums[index] != index) {
         if (nums[index] < index) {
             index ++;
         } else if (nums[index] < nums.length) {
             index = nums[index];
         } else {
             return -1;
         }
        }
        if (index >= nums.length) {
            return -1;
        }
        return index;
    }
}
