package com.hsc.other;

public class Solution812 {
    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, getSize(points[j][0] - points[i][0], points[j][1] - points[i][1],
                            points[k][0] - points[i][0], points[k][1] - points[i][1]));
                }
            }
        }
        return max;
    }

    public double getSize(int a, int b, int c, int d) {
        return Math.abs((a * d - b * c) / 2d);
    }
}
