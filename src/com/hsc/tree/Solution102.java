package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder2(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollFirst();
                line.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.add(treeNode.right);
                }
            }
            queue.addAll(treeNodes);
            res.add(line);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());
            int curLineNum = queue.size();
            for (int i = 0; i < curLineNum; i++) {
                TreeNode treeNode = queue.pollFirst();
                res.get(res.size() - 1).add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return res;
    }
}
