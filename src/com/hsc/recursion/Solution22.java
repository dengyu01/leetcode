package com.hsc.recursion;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateAll("", 0, res, n);
        return res;
    }

    private void generateAll(String current, int pos, List<String> result, int n) {
        if (n * 2 == pos) {
            if (valid(current)) {
                result.add(current);
            }
        } else {
            generateAll(current + "(", pos + 1, result, n);
            generateAll(current + ")", pos + 1, result, n);
        }
    }

    private boolean valid(String ch) {
        int left = 0;
        for (char cur: ch.toCharArray()) {
            if (cur == '(') {
                left ++;
            } else {
                left --;
            }
            if (left < 0) {
                return false;
            }
        }
        return left == 0;
    }
}
