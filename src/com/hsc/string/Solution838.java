package com.hsc.string;

public class Solution838 {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int i = 0;
        char left = 'L';
        while (i < arr.length) {
            int j = i;
            while (j < arr.length && arr[j] == '.') {
                j ++;
            }
            char right = j < arr.length? arr[j] : 'R';
            if (left == right) {
                while (i < j) {
                    arr[i++] = left;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    arr[i ++] = left;
                    arr[k --] = right;
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(arr);
    }
}
