package com.hsc.other;

public class Solution504 {
    public String convertToBase7(int num) {
        int abs = Math.abs(num);
        int pow = 0;

        while (Math.pow(7, pow + 1) < abs) {
            pow ++;
        }
        StringBuilder res = new StringBuilder();
        if (num < 0) {
            res.append("-");
        }
        while (abs > 0) {
            int shang = (int) (abs / Math.pow(7, pow));
            if (shang > 0) {
                res.append(shang);
                abs = (int) (abs % Math.pow(7, pow));
            } else {
                res.append(0);
            }
            pow --;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution504 solution504 = new Solution504();
        solution504.convertToBase7(100);
    }
}
