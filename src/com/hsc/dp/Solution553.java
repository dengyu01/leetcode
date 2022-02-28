package com.hsc.dp;

public class Solution553 {
    private double[][] dpMin;
    private double[][] dpMax;
    private int[][] dpMinIndex;
    private int[][] dpMaxIndex;


    /**
     * 有点问题，最后打印的字符串不符合要求，但是dp思路是对的
     */
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        dpMin = new double[n][n];
        dpMax = new double[n][n];
        dpMinIndex = new int[n][n];
        dpMaxIndex = new int[n][n];
        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }
        for (int len = 2; len <= n; len ++) {
            for (int i = 0; i <= n - len; i ++) {
                int lastIndex = i + len - 1;
                dpMin[i][lastIndex] = dpMin[i][i] / dpMax[i + 1][lastIndex];
                dpMinIndex[i][lastIndex] = i;
                dpMax[i][lastIndex] = dpMax[i][i] / dpMin[i + 1][lastIndex];
                dpMaxIndex[i][lastIndex] = i;
                for (int j = i + 1; j < lastIndex; j++) {
                    if (dpMin[i][j] / dpMax[j + 1][lastIndex] < dpMin[i][lastIndex]) {
                        dpMin[i][lastIndex] = dpMin[i][j] / dpMax[j + 1][lastIndex];
                        dpMinIndex[i][lastIndex] = j;
                    }
                    if (dpMax[i][j] / dpMin[j + 1][lastIndex] > dpMax[i][lastIndex]) {
                        dpMax[i][lastIndex] = dpMax[i][j] / dpMin[j + 1][lastIndex];
                        dpMaxIndex[i][lastIndex] = j;
                    }
                }
            }
        }
        System.out.println(dpMax[0][n - 1]);
        System.out.println(print(0, n - 1, 0, nums, dpMaxIndex));
        return print(0, n - 1, 0, nums, dpMaxIndex);
    }

    public String print(int i, int j, int startIndex, int[] nums, int[][] dpIndex) {
        StringBuilder res = new StringBuilder();
        if (i == j) {
            return String.valueOf(nums[i]);
        }
        int mid = dpIndex[i][j];
        if (i > startIndex) {
            res.append("(");
        }
        res.append(print(i, mid, i, nums, dpMaxIndex));
        res.append("/");
        res.append(print(mid + 1, j, i, nums, dpMinIndex));
        if (i > startIndex) {
            res.append(")");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {6, 2, 3, 4, 5};
        Solution553 solution = new Solution553();
        solution.optimalDivision(nums);
    }
}
