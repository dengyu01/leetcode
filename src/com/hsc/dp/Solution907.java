package com.hsc.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution907 {
    public int sumSubarrayMins2(int[] arr) {
        long sum = 0;
        int[] dp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            dp[i] = arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                dp[i] = Math.min(arr[j], dp[i]);
                sum += dp[i];
            }
        }
        return (int) (sum % (Math.pow(10, 9) + 7));
    }

    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = i - (stack.isEmpty()? -1 : stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty()? arr.length : stack.peek()) - i;
            stack.push(i);
        }
        long  sum = 0;
        final int MOD = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            sum = ( sum + (long) left[i] * arr[i] * right[i]) % MOD;
        }
        return (int) sum;
    }
}
