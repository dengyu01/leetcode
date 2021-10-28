package com.hsc.tree;

import com.hsc.bean.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
