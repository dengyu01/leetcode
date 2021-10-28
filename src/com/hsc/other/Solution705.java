package com.hsc.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution705 {
    private static final int BASE = 2 ^ 10;

    private ArrayList<LinkedList<Integer>> values;

    public Solution705() {

    }

    public void add(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = values.get(index).iterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if (next == key) {
                return;
            }
        }
        values.get(index).offerLast(key);
    }

    public void remove(int key) {
        int index = hash(key);
        Iterator<Integer> iterator = values.get(index).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next == key) {
                values.get(index).remove(next);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        for (int val: values.get(index)) {
            if (val == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key & (BASE - 1);
    }
}
