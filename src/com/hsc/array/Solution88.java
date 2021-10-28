package com.hsc.array;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m - 1;
        int insertIndex = last + nums2.length;
        int toInsertIndex = n - 1;
        while (last >= 0 && toInsertIndex >= 0) {
            int value1 = nums1[last];
            int value2 = nums2[toInsertIndex];
            if (value2 >= value1) {
                nums1[insertIndex] = value2;
                toInsertIndex -- ;
            } else {
                nums1[insertIndex] = value1;
                last --;
            }
            insertIndex --;
        }
        while (last >= 0) {
            nums1[insertIndex --] = nums1[last --];
        }
        while (toInsertIndex >= 0) {
            nums1[insertIndex --] = nums2[toInsertIndex --];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        Solution88 solution88 = new Solution88();
        solution88.merge(num1, 3, num2, 3);
        System.out.println(num1);
    }
}
