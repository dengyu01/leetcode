package com.hsc.tree;

import com.hsc.bean.TreeNode;

public class Solution110 {

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return l >= r ? l + 1 : r + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean res;
        res = isBalanced(root.left) && isBalanced(root.right);
        if (!res) {
            return res;
        }
        int l = getHeight(root.left);
        int r = getHeight(root.right);
        return Math.abs(l - r) <= 1;
    }
}
