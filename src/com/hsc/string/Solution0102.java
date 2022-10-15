package com.hsc.string;

import java.util.Arrays;

public class Solution0102 {
    public boolean CheckPermutation(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        num(map1, s1);
        num(map2, s2);
        return Arrays.equals(map1, map2);
    }

    public void num(int[] map, String s) {
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map[cur - 'a'] ++;
        }
    }
}
