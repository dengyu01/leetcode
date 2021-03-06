package com.hsc.dp;

public class Solution338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        int highBit = 0;
        for (int i = 1; i <= num; i++) {
            if ((i&(i-1)) == 0) {
                highBit = i;
            }
            res[i] = res[i - highBit] + 1;
        }
        return res;
    }
}
