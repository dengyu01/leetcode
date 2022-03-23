package com.hsc.tree;

public class Solution440 {
    /**
     * 注意的点：字典树思想、int越界
     */
    public int findKthNumber(int n, int k) {
        int curr = 1;
        k --;
        while (k > 0) {
            int steps = getSteps(curr, n);
            if (steps < k) {
                k = k - steps - 1;
                curr ++;
            } else {
                curr = curr * 10;
                k --;
            }
        }
        return curr;
    }

    public int getSteps(int curr, long n) {
        int steps = 0;
        long l = curr * 10L;
        long r = curr * 10L + 9;
        while (l <= n) {
            steps += Math.min(r, n) - l + 1;
            l = 10 * l;
            r = 10 * r + 9;
        }
        return steps;
    }
}
