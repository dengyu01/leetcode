package com.hsc.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution155 {
    public String reverseWords(String s) {
        List<String> str = Arrays.asList(s.split("\\s+"));
        Collections.reverse(str);
        return String.join(" ", str).trim();
    }
}
