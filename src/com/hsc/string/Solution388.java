package com.hsc.string;

import java.util.ArrayDeque;

public class Solution388 {
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        while (pos < n) {
            int depth = 1;
            // 检测当前文件所处的深度
            while (pos < n && input.charAt(pos) == '\t') {
                pos ++;
                depth ++;
            }
            // 判断当前指向的是文件还是目录，并计算长度
            boolean isFile =false;
            int len = 0;
            while (pos < n && input.charAt(pos) != '\n') {
                len ++;
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                pos ++;
            }
            // 跳过\n
            pos ++;

            // 栈中只保存当前指针的父级
            while (stack.size() >= depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                len = stack.peek() + 1 + len;
            }

            if (isFile) {
                ans = Math.max(ans, len);
            } else {
              stack.push(len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution388 solution388 = new Solution388();
        solution388.lengthLongestPath("tets\n\tyes");
    }
}
