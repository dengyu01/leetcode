package com.hsc.string;

import java.util.*;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            ++ pCount[p.charAt(i) - 'a'];
            ++ sCount[s.charAt(i) - 'a'];
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        int j = 0;
        for (int i = 0; i < sLen - pLen; i++) {
            -- sCount[s.charAt(i) - 'a'];
            ++ sCount[s.charAt(i + pLen) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
