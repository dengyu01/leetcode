package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.ArrayDeque;

public class Solution0406 {
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.push(cur);
                cur = cur.left;
            }
            cur = deque.pop();
            // visit
            if (pre == p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > p.val) {
                res = cur;
                cur = cur.left;
            } else  {
                cur = cur.right;
            }
        }
        return res;
    }
}
