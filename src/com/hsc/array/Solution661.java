package com.hsc.array;

public class Solution661 {
    int[][] index = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 0}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int sum = 0;
                int num = 0;
                for (int k = 0; k < index.length; k++) {
                    int val = getVal(img, i + index[k][0], j + index[k][1]);
                    if (val != -1) {
                        sum += val;
                        num ++;
                    }
                }
                res[i][j] = sum / num;
            }
        }
        return res;
    }

    /**
     * 这个函数显得有点多余
     */
    public int getVal(int[][] img, int i, int j) {
        if (i >= 0 && i < img.length && j >= 0 && j < img[0].length) {
            return img[i][j];
        }
        return -1;
    }
}
