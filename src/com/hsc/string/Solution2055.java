package com.hsc.string;

import java.util.ArrayList;

public class Solution2055 {
    /**
     * 超出时间限制
     */
    public int[] platesBetweenCandles2(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> la = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '|') {
                la.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int minL = r;
            int maxR = l;
            for (int j = 0; j < la.size(); j++) {
                if (la.get(j) >= l) {
                    minL = la.get(j);
                    break;
                }
            }
            for (int j = la.size() - 1; j >= 0; j--) {
                if (la.get(j) <= r) {
                    maxR = la.get(j);
                    break;
                }
            }
            int count = 0;
            for (int j = minL; j < maxR; j++) {
                if (chars[j] == '*') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] preSum = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            preSum[i] = sum;
        }
        int[] left = new int[n];
        for (int i = 0, l = -1; i < n; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[n];
        for (int i = n - 1, r = -1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = right[query[0]], y = left[query[1]];
            ans[i] = x == -1 || y == -1 || x >= y ? 0 : preSum[y] - preSum[x];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2055 solution = new Solution2055();
        int[][] arr = new int[][]{
                {2, 5}
        };
        int[] ints = solution.platesBetweenCandles("**|**|***|", arr);
    }
}
