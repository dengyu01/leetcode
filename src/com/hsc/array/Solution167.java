package com.hsc.array;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int[] res = new int[2];
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                res[0] = l;
                res[1] = r;
            } else if (sum > target) {
                r --;
            } else {
                l ++;
            }
        }
        return res;
    }
}
