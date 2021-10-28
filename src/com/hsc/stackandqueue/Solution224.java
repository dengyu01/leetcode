package com.hsc.stackandqueue;


import java.util.LinkedList;
import java.util.Stack;

public class Solution224 {
    public int calculate2(String s) {

        int res = 0;
        char curOps = ' ';
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                int number = s.charAt(i) - '0';
                i ++;
                while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                    number = number * 10 + s.charAt(i) - '0';
                    i ++;
                }
                if (curOps == ' ') {
                    res = number;
                } else if (curOps == '+') {
                    res += number;
                } else {
                    res -= number;
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                curOps = s.charAt(i);
                i++;
            } else {
                i ++;
            }
        }
        return res;
    }

    public int calculate(String s) {
        LinkedList<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;
        int res = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+') {
                sign = ops.peek();
                i ++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i ++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i ++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i ++;
            } else if (s.charAt(i) == ' ') {
                i ++;
            } else {
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                res += sign * num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution224 solution224 = new Solution224();
        int calculate = solution224.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }
}
