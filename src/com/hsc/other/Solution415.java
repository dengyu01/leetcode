package com.hsc.other;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int l = num1.charAt(i) - '0';
            int r = num2.charAt(j) - '0';
            int cur = (l + r + flag) % 10;
            flag = (l + r + flag) / 10;
            sb.append(cur);
            i --;
            j --;
        }
        while (i >= 0) {
            int l = num1.charAt(i) - '0';
            int cur = (l + flag) % 10;
            flag = (l + flag) / 10;
            sb.append(cur);
            i --;
        }
        while (j >= 0) {
            int r = num2.charAt(j) - '0';
            int cur = (r + flag) % 10;
            flag = (r + flag) / 10;
            sb.append(cur);
            j --;
        }
        if (flag == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
