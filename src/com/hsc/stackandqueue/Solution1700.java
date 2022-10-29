package com.hsc.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> stuStack = new ArrayDeque<>();
        Deque<Integer> sandStack = new ArrayDeque<>();

        for (int i = 0; i < students.length; i++) {
            stuStack.add(students[i]);
            sandStack.add(sandwiches[i]);
        }


        while (!stuStack.isEmpty() && !sandStack.isEmpty()) {
            boolean wait = true;
            for (int i = 0; i < stuStack.size(); i++) {
                Integer stu = stuStack.pop();
                if (stu.equals(sandStack.peek())) {
                    sandStack.pop();
                    wait = false;
                } else {
                    stuStack.add(stu);
                }
            }
            if (wait) {
                break;
            }
        }
        return stuStack.size();
    }
}
