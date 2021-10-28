package com.hsc.other;

public class Solution476 {
    public int findComplement2(int num) {
        int res = 0, pw = 0, cur = 0;
        while (num != 0) {
            cur = num & 0x1;
            res = res + (1 - cur) * (int) Math.pow(2, pw ++);
            num >>= 1;
        }
        return res;
    }

    public int findComplement(int num) {
        int tmp = 1;
        int tmp2 = num;
        while (num != 0) {
            tmp <<= 1;
            num >>= 1;
        }
        return tmp -  1 - tmp2;
    }
}
