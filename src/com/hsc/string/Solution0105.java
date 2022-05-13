package com.hsc.string;

public class Solution0105 {
    public boolean oneEditAway(String first, String second) {
        if (first.length() > second.length()) {
            return oneEditAway(second, first);
        }
        if (second.length() - first.length() > 1) {
            return false;
        }

        if (first.length() == second.length()) {
            int diff = 0;
            int i = 0;
            while (i < first.length()) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff ++;
                }
                i ++;
            }
            return diff == 1;
        }

        StringBuilder test = new StringBuilder();
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                test.append(second.charAt(j));
                i ++;
            }
            j ++;
        }
        return test.toString().equals(first);

    }
}
