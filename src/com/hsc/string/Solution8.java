package com.hsc.string;

public class Solution8 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int i = 0;
        long num = 0;
        boolean minus = false;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        if (s.charAt(i) == '-') {
            minus = true;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }

        while (i < s.length() && '0' <= s.charAt(i) && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
            i ++;
        }
        num = minus? -num: num;
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.myAtoi("18446744073709551617");
        System.out.println(i);
    }
}
