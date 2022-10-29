package com.hsc.dp;

public class Solution904 {
    public int totalFruit(int[] fruits) {
        int first = fruits[0], two = -1;
        int res = 0;

        int i = 0;
        while (i < fruits.length) {
            int num = 0;
            while (i < fruits.length) {
                if (two == -1 && fruits[i] != fruits[first]) {
                    two = i;
                }
                if (fruits[i] == fruits[first] || fruits[i] == fruits[two]) {
                    num ++;
                } else {
                    first = two;
                    i = two;
                    two = -1;
                    break;
                }
                i ++;
            }
            res = Math.max(res, num);
        }
        return res;
    }
}
