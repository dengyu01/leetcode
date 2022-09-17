package com.hsc.string;

import java.util.Arrays;

public class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int res = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c  - 'a';
            if (map[index] == -1) {
                map[index] = i;
            } else {
                res = Math.max(res, i - map[index] - 1);
            }
        }
        return res;
    }
}
