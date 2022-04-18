package com.hsc.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution386 {
    private List<Integer> res;

    // 击败100%
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        for (int i = 1; i < 10 && i <= n; i++) {
            res.add(i);
            di(n, i);
        }
        return res;
    }

    public void di(int n, int parent) {
        int son = parent * 10;
        if (son > n) {
            return;
        }
        for (int i = 0; i <= 9 && son + i <= n; i++) {
            res.add(son + i);
            di(n, son + i);
        }
    }

    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        int number = 1;
        for (int i = 0; i < n; i++) {
            ret.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution386 solution386 = new Solution386();
        List<Integer> integers = solution386.lexicalOrder2(23);
        System.out.println(integers);
    }
}
