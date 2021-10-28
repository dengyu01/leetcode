package com.hsc.recursion;

import java.util.HashMap;

public class Solution292 {
    private static HashMap<Integer, Boolean> cache = new HashMap<>();

    /**
     *
     * 思路错误，考虑使用数学推理的方法解题
     */
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        } else {
            return f(n - 1) || f(n - 2) || f (n - 3);
        }
    }

    private boolean f(int rest) {
        if (cache.containsKey(rest)) {
            return cache.get(rest);
        }
        boolean res = true;
        if (rest == 0) {
            cache.put(rest, res);
        } else if (rest == 1 || rest == 2 || rest == 3) {
            res = false;
        } else {
            if (rest - 3 >= 0) {
                res &= !f(rest - 3);
            }
            if (rest - 2 >= 0) {
                res &= !f(rest - 2);
            }
            if (rest - 1 >= 0) {
                res &= !f(rest - 1);
            }
        }
        cache.put(rest, res);
        return res;
    }
}
