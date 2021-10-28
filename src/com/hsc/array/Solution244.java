package com.hsc.array;

public class Solution244 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (searchBinary(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        int rows = matrix.length, cols = matrix[0].length;
        while (j >= 0 && i < rows) {
            int cur = matrix[i][j];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                i ++;
            } else {
                j --;
            }
        }
        return false;
    }

    public boolean searchBinary(int[] cow, int target) {
        int lo = 0, hi = cow.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (cow[mid] == target) {
                return true;
            } else if (cow[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
