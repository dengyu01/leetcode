package com.hsc.string;

public class Solution2038 {
    public boolean winnerOfGame(String colors) {
        while (colors.length() >= 3) {
            int aIndex = colors.indexOf("AAA");
            if (aIndex == -1) {
                return false;
            }
            colors = colors.substring(0, aIndex + 1) + colors.substring(aIndex + 2);
            int bIndex = colors.indexOf("BBB");
            if (bIndex == -1) {
                return true;
            }
            colors = colors.substring(0, bIndex + 1) + colors.substring(bIndex + 2);
        }
        return false;
    }

    /**
     * 官方题解
     */
    public boolean winnerOfGame2(String colors) {
        int[] freq = {0, 0};
        char cur = 'C';
        int cnt = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt += 1;
                if (cnt >= 3) {
                    freq[cur - 'A'] += 1;
                }
            }
        }
        return freq[0] > freq[1];
    }
}
