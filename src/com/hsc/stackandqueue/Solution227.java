package com.hsc.stackandqueue;

import java.util.LinkedList;

public class Solution227 {

    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        char preSine = '+';
        int num = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                switch (preSine) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                }
                preSine = s.charAt(i);
                num = 0;
            }
            i ++;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Solution227 solution227 = new Solution227();
        int calculate = solution227.calculate("12-3*4");
        System.out.println(calculate);
    }
}
