package com.hsc.tree;

import com.hsc.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        if (isSymmetric(root, root)) {
            if (null != root.left) {
                nodes.add(root.left);
            }
            if (null != root.right) {
                nodes.add(root.right);
            }
            return isSymmetric(nodes);
        } else {
            return false;
        }
    }

    public boolean isSymmetric(List<TreeNode> nodes) {
        if (nodes.size() == 0) {
            return true;
        }
        if (nodes.size() % 2 == 1) {
            return false;
        }
        boolean isSymmetry = true;
        for (int i = 0, j = nodes.size() - 1; i < j; i ++, j --) {
            TreeNode left = nodes.get(i);
            TreeNode right = nodes.get(j);
            isSymmetry = isSymmetry && isSymmetric(left, right);
        }

        List<TreeNode> nextNodes = new ArrayList<>();
        for (TreeNode node: nodes) {
            if (null != node.left) {
                nextNodes.add(node.left);
            }
            if (null != node.right) {
                nextNodes.add(node.right);
            }
        }
        return isSymmetry && isSymmetric(nextNodes);
    }

    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (rightNode == null || leftNode == null) {
            return false;
        }

        boolean le = leftNode.left == null? rightNode.right == null
                : rightNode.right != null && rightNode.right.val == leftNode.left.val;
        boolean ri = leftNode.right == null? rightNode.left == null
                : rightNode.left != null && leftNode.right.val == rightNode.left.val;
        return le && ri;
    }

    public static void main1(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(3);

        node11.left = node21;
        node11.right = node22;
        node21.right = node31;
        node22.right = node32;

        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(node11));

    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(1);
        TreeNode node21 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node31 = new TreeNode(3);
        TreeNode node32 = new TreeNode(4);
        TreeNode node33 = new TreeNode(4);
        TreeNode node34 = new TreeNode(3);

        node11.left = node21;
        node11.right = node22;
        node21.left = node31;
        node21.right = node32;
        node22.left = node33;
        node22.right = node34;

        Solution101 solution101 = new Solution101();
        System.out.println(solution101.isSymmetric(node11));

    }
}
