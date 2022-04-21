package com.hsc.string;

public class Solution824 {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // 击败99.78%
    public String toGoatLatin(String sentence) {
        int index = 0;
        int len = sentence.length();
        int i = 0;
        StringBuilder ans = new StringBuilder();
        // 遍历每个字母
        while (i < len) {
            // 当前单词的索引
            index ++;
            boolean isVowel = false;
            int startI = i;
            if (isVowel(sentence.charAt(i))) {
                isVowel = true;
                ans.append(sentence.charAt(i));
            }
            // 跳过首字母
            i ++;
            // 遍历一个字母，遇到空格或者字符串末尾结束
            while (i < len && sentence.charAt(i) != ' ') {
                ans.append(sentence.charAt(i));
                i ++;
            }
            if (!isVowel) {
                ans.append(sentence.charAt(startI));
            }
            ans.append("ma");
            int j = 0;
            while (j ++ < index) {
                ans.append('a');
            }
            // 添加空格
            if (i < len) {
                ans.append(' ');
                i ++;
            }
        }
        return ans.toString();
    }
}
