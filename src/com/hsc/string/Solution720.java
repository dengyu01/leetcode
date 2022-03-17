package com.hsc.string;

import java.util.Arrays;
import java.util.HashMap;

public class Solution720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        HashMap<String, Integer> map = new HashMap<>();
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String pre = word.substring(0, word.length() - 1);
            if (map.containsKey(pre) || word.length() == 1) {
                map.put(word, i);
                if (word.length() > maxLen) {
                    maxLen = word.length();
                    res = word;
                }
            }
        }
        return res;
    }
}
