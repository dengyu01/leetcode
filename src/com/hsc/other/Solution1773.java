package com.hsc.other;

import java.util.List;

public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (int i = 0; i < items.size(); i++) {
            List<String> cur = items.get(i);
            int index = match(ruleKey);
            if (cur.get(index).equals(ruleValue)) {
                res ++;
            }
        }
        return res;
    }

    private int match(String key) {
        int res = 0;
        switch (key) {
            case "type":
                break;
            case "color":
                res = 1; break;
            case "name":
                res = 2; break;
        }
        return res;
    }
}
