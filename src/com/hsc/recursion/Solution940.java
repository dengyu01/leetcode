package com.hsc.recursion;

import java.util.HashSet;

public class Solution940 {
    public int distinctSubseqII2(String s) {
        HashSet<String> res = new HashSet<>();
        HashSet<String> remove = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        f(s, 0, res, sb, remove);
        return res.size();
    }

    public void f(String s, int i, HashSet<String> set, StringBuilder sb, HashSet<String> remove) {
        if (i == s.length()) {
            if (!sb.isEmpty()) {
                set.add(sb.toString());
            }
        } else {
            char c = s.charAt(i);

            String cur = sb.toString() + c;
            if (!remove.contains(cur)) {
                sb.append(c);
                remove.add(cur);
                f(s, i + 1, set, sb, remove);
                sb.deleteCharAt(sb.length() - 1);
            }
            f(s, i + 1, set, sb, remove);
        }
    }

    public int distinctSubseqII(String s) {
        int[] g = new int[26];
        final int MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            int total = 1;
            for (int j = 0; j < 26; j++) {
                total = (total + g[j]) % MOD;
            }
            g[s.charAt(i)- 'a'] = total;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans = (ans + g[i]) % MOD;
        }
        return ans;
    }
}
