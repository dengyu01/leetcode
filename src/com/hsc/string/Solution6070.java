package com.hsc.string;

import java.util.HashMap;
import java.util.Map;

public class Solution6070 {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < s.length(); i = i + k) {
                int cur = 0;
                for (int j = 0; j < k && i + j < s.length(); j++) {
                    cur += s.charAt(i + j) - '0';
                }
                res.append(cur);
            }
            s = res.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        Solution6070 solution6070 = new Solution6070();
//        solution6070.digitSum("11111222223", 3);
        solution6070.minimumRounds(new int[] {2,2,3,3,2,4,4,4,4,4});
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> next : map.entrySet()) {
            int value = next.getValue();
            if (value < 2) {
                return -1;
            }
            res += value / 3;
            if (value % 3 != 0) {
                res++;
            }
        }
        return res;
    }

    public int maxTrailingZeros(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, maxTrailingZeros(grid, i, j));
            }
        }
        return max;
    }

    public int maxTrailingZeros(int[][] grid, int i, int j) {
        long ji = grid[i][j];
        int max = f(ji);
        // 先向右走
        for (int col = j + 1; col < grid[0].length; col++) {
            ji *= grid[i][col];
            max = Math.max(max, f(ji));
            long temp = ji;
            // 向下
            for (int row = i + 1; row < grid.length; row ++) {
                ji *= grid[row][col];
                max = Math.max(max, f(ji));
            }
            ji = temp;
            // 向上
            for (int row = i - 1; row >= 0; row --) {
                ji *= grid[row][col];
                max = Math.max(max, f(ji));
            }
            ji = temp;
        }

        // 先向下走
        ji = grid[i][j];
        for (int row = i + 1; row < grid.length; row++) {
            ji *= grid[row][j];
            max = Math.max(max, f(ji));
            long temp = ji;
            // 向右
            for (int col = j + 1; col < grid[0].length; col ++) {
                ji *= grid[row][col];
                max = Math.max(max, f(ji));
            }
            ji = temp;
        }

        // 向上走
        ji = grid[i][j];
        for (int row = i - 1; row >= 0; row --) {
            ji *= grid[row][j];
            max = Math.max(max, f(ji));
            long temp = ji;
            // 向右
            for (int col = j + 1; col < grid[0].length; col ++) {
                ji *= grid[row][col];
                max = Math.max(max, f(ji));
            }
            ji = temp;
        }
        return max;
    }

    private int f(long ji) {
        int res = 0;
        while (ji != 0 & ji % 10 == 0) {
            res ++;
            ji /= 10;
        }
        return res;
    }

}
