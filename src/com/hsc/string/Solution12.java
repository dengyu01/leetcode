package com.hsc.string;

public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        while (num / 1000 != 0) {
            res.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            res.append("CM");
            num -= 900;
        }

        if (num >= 500) {
            res.append("D");
            num -= 500;
        }

        if (num >= 400) {
            res.append("CD");
            num -= 400;
        }

        while (num / 100 != 0) {
            res.append("C");
            num -= 100;
        }

        if (num >= 90) {
            res.append("XC");
            num -= 90;
        }

        if (num >= 50) {
            res.append("L");
            num -= 50;
        }

        if (num >= 40) {
            res.append("XL");
            num -= 40;
        }

        while (num / 10 != 0) {
            res.append("X");
            num -= 10;
        }

        if (num >= 9) {
            res.append("IX");
            num -= 9;
        }

        if (num >= 5) {
            res.append("V");
            num -= 5;
        }

        if (num >= 4) {
            res.append("IV");
            num -= 4;
        }

        while (num != 0) {
            res.append("I");
            num -= 1;
        }
        return res.toString();
    }
}
