package com.hsc.array;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int mid;
        while (low <= high && low >= 0 && high <= nums.length) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int l = mid, r = mid;
                while (l - 1 >= 0 && nums[l - 1] == target) {
                    l --;
                }
                while (r + 1 <= nums.length && nums[r + 1] == target) {
                    r ++;
                }
                return new int[] {l, r};
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
