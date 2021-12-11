package com.hsc.datastructure.model;

public class TreeNode {
    public Integer key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public TreeNode(Integer x) { key = x; }

    public TreeNode(Integer value, TreeNode parent, TreeNode left, TreeNode right) {
        super();
        this.key = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
