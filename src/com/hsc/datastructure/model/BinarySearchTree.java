package com.hsc.datastructure.model;

import com.hsc.datastructure.opreation.BinarySearchTreeOp;

public class BinarySearchTree implements BinarySearchTreeOp {
    protected TreeNode root;
    protected int size;

    @Override
    public void insert(TreeNode node) {
        if (root == null) {
            root = node;
            size ++;
            return;
        }
        TreeNode y = null;
        TreeNode x = root;
        while (x != null && x.key != null) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }
        size ++;
    }

    /**
     * 情况1：z没有子女，修改其父节点，使其父节点指向null
     * 情况2：z只有一个子女，让z的父节点与z的子节点建立一条链接
     * 情况3：z有两个子节点，将z的后继节点的值赋给z，删除其后继节点。
     */
    @Override
    public TreeNode delete(TreeNode z) {
        TreeNode y;
        TreeNode x;
        // y指向待删除节点
        if (z.left == null || z.right == null) {
            y = z;
        } else {
            y = successor(z);
        }

        // x指向y的子节点(y的子节点最多只可能只有1个，因为y是z（z只有1个子节点才指向z）或者z的后继节点（比z大的最小节点）)
        if (y.left != null) {
            x = y.left;
        } else {
            x = y.right;
        }
        if (x != null) {
            x.parent = y.parent;
        }
        if (y.parent == null) {
            // 待删除的节点是根节点
            root = x;
        } else {
            // 删除y节点
            if (y.parent.left == y) {
                y.parent.left = x;
            } else {
                y.parent.right = x;
            }
        }
        // 情况3：将后继节点转移到z节点
        if (y != z) {
            z.key = y.key;
        }
        size --;
        return y;
    }

    @Override
    public void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key);
            inorder(node.right);
        }
    }

    @Override
    public TreeNode search(TreeNode root, TreeNode node) {
        if (root == null || node.key == root.key) {
            return root;
        }
        if (node.key < root.key) {
            return search(root.left, node);
        } else {
            return search(root.right, node);
        }
    }

    @Override
    public TreeNode successor(TreeNode node) {
        if (node.right != null) {
            return minimum(node.right);
        }
        TreeNode y = node.parent;

        // 找到一个祖先节点（满足node节点在它的左边）
        while (y != null && y.right == node) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    @Override
    public TreeNode minimum(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, Long max, Long min) {
        if (root == null || root.key == null) {
            return true;
        }
        if (root.key >= max || root.key <= min) {
            return false;
        }
        return isValidBST(root.left, (long) root.key, min) && isValidBST(root.right, max, (long) root.key);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(new TreeNode(5));
        tree.insert(new TreeNode(1));
        tree.insert(new TreeNode(4));
        tree.insert(new TreeNode(3));
        tree.insert(new TreeNode(6));
        tree.root.left.left = new TreeNode(8);
        System.out.println(tree.isValidBST(tree.root));
        tree.delete(new TreeNode(8));
        System.out.println(tree.isValidBST(tree.root));
    }
}
