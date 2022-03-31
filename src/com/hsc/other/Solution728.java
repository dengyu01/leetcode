package com.hsc.other;

import java.util.ArrayList;
import java.util.List;

public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isZiChuShu(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isZiChuShu(int num) {
        int temp = num;
        while (temp > 0) {
            int cur = temp % 10;
            if (cur == 0 || num % cur != 0) {
                return false;
            }
            temp = temp / 10;
        }
        return true;
    }
}
