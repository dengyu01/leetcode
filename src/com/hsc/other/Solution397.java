package com.hsc.other;

public class Solution397 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n + 1) + 1, integerReplacement(n - 1) + 1);
        }
    }

    public int integerReplacement2(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 0x1) == 0) {
                n >>>= 1;
                count ++;
            } else if ((n & 0x2) == 0) {
                n -= 1;
                count ++;
            } else {
                if(n == 3) {
                    count += 2;
                    break;
                }
                n += 1;
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 2147483647;
        int num1 = 7;
//        System.out.println(num / 2);
        Solution397 solution397 = new Solution397();
        int res = solution397.integerReplacement2(num);
        System.out.println(res);
    }
}
