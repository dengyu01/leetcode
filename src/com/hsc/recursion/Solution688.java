package com.hsc.recursion;

public class Solution688 {
    static int[][] move = new int[][]{{-2, -1}, {-2, 1}, {-1, +2}, {1, +2}, {+2, -1}, {+2, +1}, {-1, -2}, {+1, -2}};

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int step = 0; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (step == 0) {
                        dp[step][i][j] = 1d;
                    } else {
                        for (int[] m : move) {
                            int nextI = i + m[0];
                            int nextJ = j + m[1];
                            if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n) {
                                dp[step][i][j] += dp[step - 1][nextI][nextJ] / 8;
                            }
                        }
                    }
                }
            }
        }
        return dp[k][row][column];
    }
//    public double knightProbability(int n, int k, int row, int column) {
//        return knightProbability(row, column, 0, n, k);
//    }
//
//    public double knightProbability(int row, int col, int num, int n, int k) {
//        if (row < 0 || col < 0 || row >= n || col >= n) {
//            return 0d;
//        }
//        if (num == k) {
//            return 1d;
//        }
//        double res = 0;
//        res += 1 / 8.0 * knightProbability(row - 2, col - 1, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row - 2, col + 1, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row - 1, col + 2, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row + 1, col + 2, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row + 2, col - 1, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row + 2, col + 1, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row - 1, col - 2, num + 1, n, k);
//        res += 1 / 8.0 * knightProbability(row + 1, col - 2, num + 1, n, k);
//        return res;
//    }
}
