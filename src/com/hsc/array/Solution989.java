package com.hsc.array;

import sun.security.krb5.internal.tools.Klist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> KList = new ArrayList<>();
        while (K != 0) {
            KList.add((int) (K % 10));
            K /= 10;
        }
        if (KList.size() == 0) {
            KList.add(0);
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> AList = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.reverse(AList);
        int flag = 0;
        int i = 0, j = 0;
        while (i < AList.size() && j < KList.size()) {
            int sum = AList.get(i) + KList.get(j) + flag;
            res.add(sum % 10);
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
            i++;
            j++;
        }
        while (i < AList.size()) {
            int sum = AList.get(i++) + flag;
            res.add(sum % 10);
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        while (j < KList.size()) {
            int sum =KList.get(j++) + flag;
            res.add(sum % 10);
            if (sum >= 10) {
                flag = 1;
            } else {
                flag = 0;
            }
        }
        if (flag == 1) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] A = new int[] {2,1,5};
        Solution989 test = new Solution989();
        test.addToArrayForm(A, 806);
    }
}
