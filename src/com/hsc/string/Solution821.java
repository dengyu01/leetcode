package com.hsc.string;

import java.util.Arrays;

public class Solution821 {
    public int[] shortestToChar1(String s, char c) {
        int[] indexArr = new int[s.length()];
        int index = s.indexOf(c);
        Arrays.fill(indexArr, 0, index + 1, index);
        int nextIndex = s.indexOf(c, index + 1);
        for (int i = index + 1; i < s.length(); i++) {
            if (nextIndex != -1 && i > nextIndex) {
                index = nextIndex;
                nextIndex = s.indexOf(c, i);
            }
            if (nextIndex != -1) {
                indexArr[i] = i - index < nextIndex - i ? index : nextIndex;
            } else {
                indexArr[i] = index;
            }
        }
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Math.abs(i - indexArr[i]);
        }
        return res;
    }

    public int[] shortestToChar2(String s, char c) {
        int[] res = new int[s.length()];
        int leftIndex = -1;
        int rightIndex = s.indexOf(c);
        for (int i = 0; i < s.length(); i++) {
            if (rightIndex != -1 && i > rightIndex) {
                leftIndex = rightIndex;
                rightIndex = s.indexOf(c, i);
            }
            if (leftIndex == -1) {
                res[i] = rightIndex - i;
            } else if (rightIndex == -1) {
                res[i] = i - leftIndex;
            } else {
                res[i] = Math.min(i - leftIndex, rightIndex - i);
            }
        }
        return res;
    }

    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        int len = s.length();
        int idx = -len;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            res[i] = i - idx;
        }
        idx = len << 1;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                idx = i;
            }
            res[i] = Math.min(res[i], idx - i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution821 solution821 = new Solution821();
        int[] ints = solution821.shortestToChar("loveleetcode", 'e');
        System.out.println(Arrays.toString(ints));
    }
}
