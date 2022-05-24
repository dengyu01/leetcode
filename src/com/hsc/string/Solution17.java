package com.hsc.string;

import java.util.ArrayList;
import java.util.List;

public class Solution17 {
    private static List<List<String>> list = new ArrayList<>();

    static {
        list.add(List.of("a", "b", "c"));
        list.add(List.of("d", "e", "f"));
        list.add(List.of("g", "h", "i"));
        list.add(List.of("j", "k", "l"));
        list.add(List.of("m", "n", "o"));
        list.add(List.of("p", "q", "r", "s"));
        list.add(List.of("t", "u", "v"));
        list.add(List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        List<String> res = new ArrayList<>(list.get(chars[0] - '0' - 2));
        for (int i = 1; i < chars.length; i++) {
            ArrayList<String> cur = new ArrayList<>();
            List<String> strings = list.get(chars[i] - '0' - 2);
            for (int j = 0; j < res.size(); j++) {
                for (int k = 0; k < strings.size(); k++) {
                    cur.add(res.get(j) + strings.get(k));
                }
            }
            res = cur;
        }
        return res;
    }
}
