package com.hsc.string;

public class Solution6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return String.valueOf(s);
        }
        char[] chars = s.toCharArray();
        int interval = (numRows - 1) << 1;
        var res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i >= chars.length) {
                break;
            }
            res.append(chars[i]);
            int curNums = (numRows - i - 1) << 1;
            int j = i;
            while (j < chars.length) {
                if (i > 0 && i < numRows - 1 && j + curNums < chars.length) {
                    res.append(chars[j + curNums]);
                }
                if (j + interval < chars.length) {
                    res.append(chars[j + interval]);
                }
                j = j + interval;
            }
        }
        return res.toString();
    }
}
