package com.hsc.string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution856 {
    public int scoreOfParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                int left = stack.pop();
                map.put(left, i);
            }
        }
        return f(s, 0, s.length() - 1, map);
    }

    public int f(String s, int l, int r, HashMap<Integer, Integer> map) {
        if (r - l == 1) {
            return 1;
        } else {
            int right = map.get(l);
            if (right < r) {
                return f(s, l, right, map) + f(s, right + 1, r, map);
            } else {
                return 2 * f(s, l + 1, r - 1, map);
            }
        }
    }
}
