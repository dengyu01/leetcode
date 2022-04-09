package com.hsc.other;

public class Solution780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        if (tx < sx || ty < sy) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % tx == 0;
        }
        return (tx - sx) % ty == 0;
    }
}
