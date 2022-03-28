package com.hsc.other;

public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int prev = n % 2;
        n = n >> 1;
        while (n != 0) {
            int cur = n % 2;
            if (cur == prev) {
                return false;
            }
            prev = cur;
            n = n >> 1;
        }
        return true;
    }
}
