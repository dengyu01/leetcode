package com.hsc.tree;

import com.hsc.bean.ListNode;
import com.hsc.bean.TreeNode;

import java.util.ArrayList;

public class Solution1367 {
    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if(head.val != root.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public boolean isSubPath2(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        TreeNode[] stack = new TreeNode[2500];
        int top = -1;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode p = root;
        TreeNode last = null;
        while (p != null || top != -1) {
            if (p != null) {
                stack[++top] = p;
                p = p.left;
            } else {
                p = stack[top];
                if (p.right != null && p.right != last) {
                    p = p.right;
                } else {
                    top--;
                    if (p.val == list.get(list.size() - 1)) {
                         if (isSubPath(list, stack, top)) {
                             return true;
                         }
                    }
                    last = p;
                    p = null;
                }
            }
        }
        return false;
    }

    public boolean isSubPath(ArrayList<Integer> list, TreeNode[] stack, int top) {
        if (list.size() - 2 > top) {
            return false;
        }
        for (int i = list.size() - 2, j = top; i >= 0; i--, j--) {
            if (list.get(i) != stack[j].val) {
                return false;
            }
        }
        return true;
    }

    public static void main1(String[] args) {
        Solution1367 solution1367 = new Solution1367();

        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(8);
        head.next = head1;
        head1.next = head2;

        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(1);

        TreeNode right1 = new TreeNode(4);
        TreeNode right2 = new TreeNode(2);
        TreeNode right3 = new TreeNode(6);
        TreeNode right4 = new TreeNode(8);
        TreeNode right5 = new TreeNode(1);
        TreeNode right6 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        left1.right = left2;
        left2.left = left3;

        right1.left = right2;
        right2.left = right3;
        right2.right = right4;
        right4.left = right5;
        right4.right = right6;

        solution1367.isSubPath(head, root);

    }

    public static void main(String[] args) {
        Solution1367 solution1367 = new Solution1367();

        ListNode head = new ListNode(3);
        ListNode head1 = new ListNode(9);
        head.next = head1;

        TreeNode root = new TreeNode(7);

        TreeNode left1 = new TreeNode(8);
        TreeNode left2 = new TreeNode(9);
        TreeNode left3 = new TreeNode(10);
        TreeNode left4 = new TreeNode(8);

        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(9);
        TreeNode right3 = new TreeNode(5);
        TreeNode right4 = new TreeNode(4);
        TreeNode right5 = new TreeNode(1);

        root.left = left1;
        root.right = right1;

        left1.left = left2;
        left1.right = left3;
        left3.right = left4;

        right1.left = right2;
        right2.left = right3;
        right2.right = right4;
        right3.left = right5;

        solution1367.isSubPath(head, root);
    }
}
