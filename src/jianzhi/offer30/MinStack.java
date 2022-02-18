package jianzhi.offer30;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            Integer top = minStack.peek();
            if (x <= top) {
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        Integer pop = stack.pop();
        if (pop.equals(min())) {
            minStack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        return -1;
    }

    public int min() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        return -1;
    }
}
