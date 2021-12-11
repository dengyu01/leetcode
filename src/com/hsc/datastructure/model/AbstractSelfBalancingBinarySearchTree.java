package com.hsc.datastructure.model;

public abstract class AbstractSelfBalancingBinarySearchTree extends BinarySearchTree {

    protected TreeNode leftRotate(TreeNode x) {
        TreeNode temp = x.right;
        temp.parent = x.parent;

        x.right = temp.left;
        if (x.right != null) {
            x.right.parent = x;
        }

        temp.left = x;
        x.parent = temp;

        if (temp.parent != null) {
            if (x == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

    protected TreeNode rightRotate(TreeNode node) {
        TreeNode temp = node.left;
        temp.parent = node.parent;

        node.left = temp.right;
        if (node.left != null) {
            node.left.parent = node;
        }

        temp.right = node;
        node.parent = temp;

        // temp took over node's place so now its parent should point to temp
        if (temp.parent != null) {
            if (node == temp.parent.left) {
                temp.parent.left = temp;
            } else {
                temp.parent.right = temp;
            }
        } else {
            root = temp;
        }

        return temp;
    }

}
