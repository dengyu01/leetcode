package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            ArrayList<TreeNode> res = new ArrayList<>();
            return res;
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lList = generateTrees(start, i - 1);
            List<TreeNode> rList = generateTrees(i + 1, end);

            for(TreeNode lNode: lList) {
                for (TreeNode rNode: rList) {
                    TreeNode midNode = new TreeNode(i);
                    midNode.left = lNode;
                    midNode.right = rNode;
                    res.add(midNode);
                }
            }
        }
        return res;
    }
}
