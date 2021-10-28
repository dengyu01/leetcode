package com.hsc.other;

import java.util.ArrayList;
import java.util.List;

public class Solution202 {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do {
            slow = chai(slow);
            fast = chai(fast);
            fast = chai(fast);
        } while (slow != fast);
        return slow == 1;
    }

    public int chai(int n) {
        int num = 0;
        while (n > 0) {
            int j = n % 10;
            num += j * j;
            n = n / 10;
        }
        return num;
    }

//    public static void main(String[] args) {
//        boolean happy = isHappy(19);
//
//    }
}
