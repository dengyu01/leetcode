package com.hsc.string;

import java.util.*;
import java.util.stream.Collectors;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    public String getKey(String  s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            Integer val = map.getOrDefault(c, 0);
            map.put(c, val + 1);
        }
        StringBuilder res = new StringBuilder();
        Set<Character> ke = map.keySet();
        for (Character key: ke) {
            Integer integer = map.get(key);
            res.append(key).append(integer);
        }
        return res.toString();
    }
}
