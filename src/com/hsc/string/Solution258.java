package com.hsc.string;

public class Solution258 {
    public int addDigits(int num) {
        while (num > 9) {
            num = addDigitsOne(num);
        }
        return num;
    }

    public int addDigitsOne(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }
}
