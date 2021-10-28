package com.hsc.string;

public class Solution1047 {
    private int hasRepeat(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return i;
            }
        }
        return -1;
    }

    public String removeDuplicates2(String S) {
        String res = S;
        int dupIndex = hasRepeat(res);
        while (dupIndex != -1) {
            int i = dupIndex -1;
            int j = dupIndex + 2;
            String temp = res;
            while (i >= 0 && j < res.length() && res.charAt(i) == res.charAt(j)) {
                i --;
                j ++;
            }
            if (i >= 0) {
                res = temp.substring(0, i + 1);
            } else {
                res = "";
            }
            if (j < temp.length()) {
                res += temp.substring(j);
            }
            dupIndex = hasRepeat(res);
        }
        return res;
    }

    public String removeDuplicates(String S) {
        StringBuilder res = new StringBuilder();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (top > -1 && ch == res.charAt(top)) {
                res.deleteCharAt(top);
                top --;
            } else {
                res.append(ch);
                top ++;
            }
        }
        return res.toString();
    }
}
