package com.hsc.array;

public class Solution1219 {
    public int getMaximumGold(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                   path[i][j] = 1;
                }
                if (path[i][j] == 0) {
                    max = Math.max(max, find(grid, path, i, j, 0));
                }
            }
        }
        return max;
    }

    public int find(int[][] grid, int[][] path, int i, int j, int curGold) {
        path[i][j] = 1;
        curGold += grid[i][j];
        int max = curGold;
        // 往上走
        if (i > 0 && path[i - 1][j] != 1 && grid[i - 1][j] != 0) {
            max = find(grid, path, i - 1, j, curGold);
        }
        // 往左走
        if (j > 0 && path[i][j - 1] == 0 && grid[i][j - 1] != 0) {
            max = Math.max(max, find(grid, path, i, j - 1, curGold));
        }
        // 往右走
        if (j < grid[0].length - 1 && path[i][j + 1] == 0 && grid[i][j + 1] != 0) {
            max = Math.max(max, find(grid, path, i, j + 1, curGold));
        }
        // 往下走
        if (i < grid.length - 1 && path[i + 1][j] == 0 && grid[i + 1][j] != 0) {
            max = Math.max(max, find(grid, path, i + 1, j, curGold));
        }
        path[i][j] = 0;
        return max;
    }
}
