package com.hsc.other;

public class Solution7 {
    public int reverse(int x) {
        boolean minus = false;
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            minus = true;
        }
        String s = sb.reverse().toString();
        int res;
        try {
             res = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
        return minus ? -res : res;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int reverse = solution7.reverse(1534236469);
        System.out.println(reverse);
    }
}
