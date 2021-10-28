package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution107 {
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        TreeNode firstNode = new TreeNode(0);
//        firstNode.left = root;
//        List<TreeNode> firstList = new ArrayList<>();
//        firstList.add(firstNode);
//        List<TreeNode> nextList = levelOrderBottom(firstList);
//        while (nextList.size() != 0) {
//            List<Integer> nextValList = new ArrayList<>();
//            for (TreeNode node: nextList) {
//                nextValList.add(node.val);
//            }
//            res.add(nextValList);
//            nextList = levelOrderBottom(nextList);
//        }
//        Collections.reverse(res);
//        return res;
//    }
//
//    public List<TreeNode> levelOrderBottom(List<TreeNode> rootList) {
//        List<TreeNode> res = new ArrayList<>();
//        for (TreeNode node: rootList) {
//            if (null != node.left) {
//                res.add(node.left);
//            }
//            if (null != node.right) {
//                res.add(node.right);
//            }
//        }
//        return res;
//    }

    private LinkedList<List<Integer>> lists;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        lists = new LinkedList<>();
        levelOrderBottom(root, 0);
        return lists;
    }

    public void levelOrderBottom(TreeNode node, int level) {
        if (null != node) {
            if (level >= lists.size()) {
                lists.addFirst(new ArrayList<Integer>());
            }
            List<Integer> cur = lists.get(lists.size() - level);
            cur.add(node.val);
            levelOrderBottom(node.left, level + 1);
            levelOrderBottom(node, level + 1);
        }
    }

}
