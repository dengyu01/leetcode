package com.hsc.array;

public class Solution1004 {
//    public int longestOnes(int[] A, int K) {
//        int[] P = new int[A.length + 1];
//        for (int i = 1; i < P.length; i++) {
//            P[i] = P[i - 1] +  1 - A[i - 1];
//        }
//        int res = 0;
//        for (int right = 0; right < A.length; right++) {
//            int left = binearySearch(P, P[right + 1] - K);
//            res = Math.max(res, right - left + 1);
//        }
//        return res;
//    }
//
//    private int binearySearch(int[] P, int target) {
//        int low = 0, high = P.length - 1;
//        while (low < high) {
//            int mid = (high - low) / 2 + low;
//            if (P[mid] < target) {
//                low = mid + 1;
//            } else {
//                high = mid;
//            }
//        }
//        return low;
//    }

    public int longestOnes(int[] A, int K) {
        int res = 0, lsum = 0, left = 0, rsum = 0;
        for (int right = 0; right < A.length; right++) {
            rsum += 1 - A[right];
            while (lsum < rsum - K) {
                lsum += 1 - A[left];
                left ++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
