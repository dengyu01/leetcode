package com.hsc.array;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            int index = 0;
            while (index < nums2.length && nums2[index] != cur) {
                index++;
            }
            while (index < nums2.length) {
                if (nums2[index] > cur) {
                    res[i] = nums2[index];
                    break;
                }
                index++;
            }
            if (index == nums2.length) {
                res[i] = -1;
            }
        }
        return res;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int cur = nums2[i];
            while (!stack.isEmpty() && cur > stack.peek()) {
                stack.pop();
            }
            map.put(cur, stack.isEmpty() ? -1 : stack.peek());
            stack.push(cur);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
