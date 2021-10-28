package com.hsc.string;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int index = 0;
        int p = 0;
        while (p < t.length() && index < s.length()) {
            if (tChars[p++] == sChars[index]) {
                index ++;
            }
        }
        return index == s.length();
    }
}
