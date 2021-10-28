package com.hsc.stackandqueue;

import java.util.LinkedList;

public class Solution946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIndex = 0, popIndex = 0;
        LinkedList<Integer> push = new LinkedList<>();
        while (pushIndex < pushed.length) {
            push.push(pushed[pushIndex]);
            while (!push.isEmpty() && push.peek() == popped[popIndex]) {
                popIndex ++;
                push.pop();
            }
            pushIndex ++;
        }
        while (!push.isEmpty()) {
            Integer pop = push.pop();
            if (pop == popped[popIndex]) {
                popIndex ++;
            } else {
                break;
            }
        }
        return popIndex == popped.length;
    }
}
