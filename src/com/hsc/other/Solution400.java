package com.hsc.other;

public class Solution400 {
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d ++;
            count *= 10;
        }
        int startNum = (int) Math.pow(10, d - 1);
        int num = startNum +  (n - 1) / d;
        // n所在数的前面所有数的位数之和(n - 1) / d * d， 记为x，d - (n - x) + 1即为第n位所在位数（从该数往左数）
        int digitIndex = d - (n - ((n - 1) / d * d)) + 1;
        if (digitIndex > 1) {
            num = num / (int) Math.pow(10, digitIndex - 1);
        }
        return num % 10;
    }

    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        solution400.findNthDigit(1000);
    }
}
