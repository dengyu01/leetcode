package com.hsc.array;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = n - 1;
            while (lo < hi) {
                temp = matrix[i][lo];
                matrix[i][lo++] = matrix[i][hi];
                matrix[i][hi--] = temp;
            }
        }
    }
}
