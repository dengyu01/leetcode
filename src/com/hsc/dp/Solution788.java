package com.hsc.dp;

public class Solution788 {
    static int[] check = new int[] {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String cur = String.valueOf(i);
            boolean valid = true;
            boolean diff = false;
            for (int j = 0; j < cur.length(); j++) {
                char ch = cur.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                }
                if (check[ch - '0'] == 1) {
                    diff = true;
                }
                if (valid && diff) {
                    ans ++;
                }
            }
        }
        return ans;
    }
}
