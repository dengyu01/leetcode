package com.hsc.array;

public class Solution1476 {
    int[][] arr;

    public Solution1476(int[][] rectangle) {
        arr = new int[rectangle.length][];
        for (int i = 0; i < rectangle.length; i++) {
            arr[i] = new int[rectangle[i].length];
            for (int j = 0; j < rectangle[i].length; j++) {
                arr[i][j] = rectangle[i][j];
            }
        }
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i ++) {
            for (int j = col1; j <= col2; j ++) {
                arr[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return arr[row][col];
    }
}
