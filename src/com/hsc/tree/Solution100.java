package com.hsc.tree;

import com.hsc.bean.TreeNode;

public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == q && null == p) {
            return true;
        } else if (null == q || null == p) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node13 = new TreeNode(3);
        node11.left = node12;
        node11.right = node13;

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        node21.left = node22;
        node21.right = node23;

        Solution100 solution100 = new Solution100();
        System.out.println(solution100.isSameTree(node11, node21));
    }
}
