package com.hsc.array;

public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            int num = max - i;
            while (num > 0 && i < arr.length) {
                i = i + 1;
                if (arr[i] > max) {
                    num += arr[i] - max;
                    max = arr[i];
                }
                num --;
            }
            res += 1;
        }
        return res;
    }
}
