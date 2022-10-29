package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class Solution105 {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[pre_left]);
        int inRootIndex = map.get(preorder[pre_left]);

        int size = inRootIndex - in_left;

        root.left = buildTree(preorder, inorder, pre_left + 1, pre_left + size, in_left, inRootIndex - 1);
        root.right = buildTree(preorder, inorder, pre_left + size + 1, pre_right, inRootIndex + 1, in_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }
}
