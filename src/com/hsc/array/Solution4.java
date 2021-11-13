package com.hsc.array;

public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            double leftMedian = findMedianSortedArrays(nums1, nums2, len / 2);
            double rightMedian = findMedianSortedArrays(nums1, nums2, len / 2 + 1);
            return (leftMedian + rightMedian) / 2.0;
        } else {
            return findMedianSortedArrays(nums1, nums2, len / 2 + 1);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2, int k) {
        int l1 = 0, l2 = 0;

        while (true) {
            if (l1 == nums1.length) {
                return nums2[l2 + k - 1];
            }
            if (l2 == nums2.length) {
                return nums1[l1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[l1], nums2[l2]);
            }
            int half = k / 2;
            int nextL1 = Math.min(nums1.length, l1 + half) - 1;
            int nextL2 = Math.min(nums2.length, l2 + half) - 1;
            if (nums1[nextL1] <= nums2[nextL2]) {
                k = k - nextL1 + l1 - 1;
                l1 = nextL1 + 1;
            } else {
                k = k - nextL2 + l2 - 1;
                l2 = nextL2 + 1;
            }
        }
    }
}
