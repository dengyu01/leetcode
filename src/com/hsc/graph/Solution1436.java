package com.hsc.graph;

import java.util.HashSet;
import java.util.List;

public class Solution1436 {
    public String destCity(List<List<String>> paths) {
        String res = "";
        HashSet<String> cities = new HashSet<>();
        for (List path: paths) {
            cities.add((String) path.get(0));
        }
        for (List path: paths) {
            String cur = (String) path.get(1);
            if (!cities.contains(cur)) {
                res = cur;
            }
        }
        return res;
    }
}
