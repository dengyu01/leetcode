package com.hsc.array;

import com.hsc.tree.Solution100;

public class Solution1007 {
//    public int minDominoRotations(int[] A, int[] B) {
//        int[] changeA = new int[7];
//        int[] changeB = new int[7];
//        for (int i = 0; i < changeA.length; i++) {
//            if (i != A[0] && i != B[0]) {
//                changeA[i] = -1;
//            }
//        }
//        int min = Integer.MAX_VALUE;
//        if (A[0] != B[0]) {
//            changeA[B[0]] ++;
//        }
//        for (int i = 1; i < A.length; i++) {
//            if (changeA[A[i]] == -1 && changeA[B[i]] == -1) {
//                return -1;
//            } else {
//                if (A[0] != A[i] && A[0] != B[i]) {
//                    changeA[A[0]] = -1;
//                }
//                if (B[0] != A[i] && B[0] != B[i]) {
//                    changeA[B[0]] = -1;
//                }
//                if (changeA[B[i]] != -1 && A[i] != B[i]) {
//                    changeA[B[i]] ++;
//                }
//            }
//        }
//        for (int i = 0; i < changeA.length; i++) {
//            if (changeA[i] != -1) {
//                min = Math.min(min, Math.min(changeA[i], A.length - changeA[i]));
//            }
//        }
//        return min;
//    }
    public int check(int num, int[] A, int[] B) {
        int chA = 0, chB = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != num && B[i] != num) {
                return -1;
            } else if (A[i] != num) {
                chA ++;
            } else if (B[i] != num) {
                chB ++;
            }
        }
        return Math.min(chA, chB);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int res = check(A[0], A, B);
        if (res != -1 || A[0] == B[0]) {
            return res;
        } else {
            return check(B[0], A, B);
        }
    }

    public static void main(String[] args) {
        Solution1007 solution1007 = new Solution1007();
        int[] A = new int[] {1,2,1,1,1,2,2,2};
        int[] B = new int[] {2,1,2,2,2,2,2,2};
        solution1007.minDominoRotations(A, B);
    }
}
