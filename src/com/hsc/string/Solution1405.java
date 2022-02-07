package com.hsc.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 贪心策略：每次选择剩余次数最多的字符串，并且当末尾两个字符相等时，需要排除这个字符
 */
public class Solution1405 {
    private final HashMap<String, Integer> map = new HashMap<>();

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();

        map.put("a", a);
        map.put("b", b);
        map.put("c", c);

        String key = getMaxStrExcept("");
        String last = "";
        while (!isEnd()) {
            key = getMaxStrExcept(last);
            append(res, key, last);
            int m = res.length();
            if (m > 2 && res.charAt(m - 1) == res.charAt(m - 2)) {
                last = String.valueOf(res.charAt(m - 1));
            } else {
                last = "";
            }
        }
        String finalKey = map.entrySet().stream()
                .filter(entry -> entry.getValue() != 0).collect(Collectors.toList()).get(0).getKey();
        append(res, finalKey, last);
        if (map.get(finalKey) > 0) {
            append(res, finalKey, last);
        }
        return res.toString();

    }

    private boolean isEnd() {
        int zeroNum = 0;
        long count = map.entrySet().stream().filter(entry -> entry.getValue() == 0).count();
        if (count >= 2) {
            return true;
        }
        return false;
    }

    private void append(StringBuilder res, String key, String last) {
        if (key.isEmpty()) {
            return;
        }
        if (last.equals(key)) {
            return;
        }
        int num = map.get(key);
        res.append(key);
        num --;
        map.put(key, num);
    }

    private String getMaxStrExcept(String ex) {
        int max = 0;
        String key = "";
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next = iterator.next();
            String cur = next.getKey();
            if (ex.equals(cur)) {
                continue;
            }
            if (next.getValue() > max) {
                max = next.getValue();
                key = cur;
            }
        }
        return key;
    }
}
