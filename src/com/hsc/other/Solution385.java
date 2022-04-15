package com.hsc.other;

import java.util.List;

public class Solution385 {
    private int line;

    public NestedInteger deserialize(String s) {
        char i = s.charAt(0);
        if (i == '-' || (i <= '9' && i >= '0')) {
            return new NestedInteger(parseNum(s, 0));
        }
        return de(s, 1);
    }

    public int parseNum(String s, int index) {
        int num = 0;
        int fu = 1;
        if (s.charAt(index) == '-') {
            index ++;
            fu = -1;
        }
        while(index < s.length() && s.charAt(index) != ',' && s.charAt(index) != ']') {
            num = num * 10 + (int) (s.charAt(index) - '0');
            index ++;
        }
        line = index;
        return num * fu;
    }

    public NestedInteger de(String s, int index) {
        int len = s.length();
        NestedInteger res = new NestedInteger();
        int i = index;
        while (i < len && s.charAt(i) != ']') {
            char cur = s.charAt(i);
            if (cur == '[') {
                i ++;
                res.add(de(s, i));
                i = line;
            } else if (cur == '-' || (cur <= '9' && cur >= '0')) {
                int num = 0;
                num = parseNum(s, i);
                res.add(new NestedInteger(num));
                if (i < len && s.charAt(i) == ']') {
                    return res;
                }
                i = line;
            } else {
                i ++;
            }
        }
        line = ++ i;
        return res;
    }
}

 class NestedInteger {
     public NestedInteger() {
     }

     public NestedInteger(int value) {
     }

     public boolean isInteger() {
         return false;
     }

     public Integer getInteger() {
         return null;
     }

     public void setInteger(int value) {
     }

     public void add(NestedInteger ni) {
     }

     public List<NestedInteger> getList() {
         return null;
     }
 }
