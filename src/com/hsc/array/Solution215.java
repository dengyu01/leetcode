package com.hsc.array;

import java.util.Random;

public class Solution215 {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    private int quickSort(int[] num, int l, int r, int k) {
        int mid = randomPartition(num, l, r);
        if (mid == num.length - k) {
            return num[mid];
        } else {
            return mid < num.length - k? quickSort(num, mid + 1, r, k): quickSort(num, l, mid -1, k);
        }
    }

    // 牛批
    private int randomPartition(int[] nums, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(nums, i, r);
        return patition(nums, l, r);
    }

    private int patition(int[] num, int l, int r) {
        int i = l - 1, x = num[r];
        for (int j = l; j < r; ++j) {
            if (num[j] <= x) {
                swap(num, ++i, j);
            }
        }
        swap(num, i + 1, r);
        return i + 1;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
