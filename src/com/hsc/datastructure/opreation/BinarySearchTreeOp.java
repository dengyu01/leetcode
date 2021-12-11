package com.hsc.datastructure.opreation;

import com.hsc.datastructure.model.TreeNode;

public interface BinarySearchTreeOp {
    public void insert(TreeNode node);
    public TreeNode delete(TreeNode node);
    public void inorder(TreeNode node);
    public TreeNode search(TreeNode root, TreeNode node);
    public TreeNode successor(TreeNode node);
    public TreeNode minimum(TreeNode node);
    public boolean isValidBST(TreeNode root);
}
