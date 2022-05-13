package com.hsc.other;

import java.util.Queue;

public class Test2 {

    private int[] queueArray;
    private int size;
    private int head;
    private int tail;
    private int length = 128;

    public Test2() {
        this.queueArray = new int[length];
    }

    public boolean offer(int i) {
        // 队满
        if (size == 128) {
            return false;
        }

        tail = (tail + 1) % length;
        queueArray[tail] = i;
        size ++;
        return true;
    }

    public int poll() {
        //队空
        if (size == 0) {
            throw new RuntimeException("队空");
        }
        int res = queueArray[head];
        head = (head + 1) % length;
        size --;
        return res;
    }

    public int peek() {
        return queueArray[head];
    }
}
