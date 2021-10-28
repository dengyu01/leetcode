package com.hsc.array;

public class Solution304 {
    private int[][] sum;

    public Solution304(int[][] matrix) {
        if (matrix.length > 0) {
            sum = new int[matrix.length][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    sum[i][j + 1] = sum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += sum[i][col2 + 1] - sum[i][col1];
        }
        return res;
    }
}
