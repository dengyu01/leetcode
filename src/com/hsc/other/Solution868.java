package com.hsc.other;

public class Solution868 {
    public int binaryGap(int n) {
        int ri = -1;
        int i = 0;
        int max = 0;
        // 找左端点
        while (n > 0) {
            if ((n & 0x1) == 1) {
                if (ri != -1) {
                    max = Math.max(i - ri, max);
                }
                ri = i;
            }
            n >>= 1;
            i ++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution868 solution868 = new Solution868();
        solution868.binaryGap(22);
    }
}
