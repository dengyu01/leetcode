package com.hsc.tree;

import com.hsc.bean.ListNode;
import com.hsc.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class SolutionInterview0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        ArrayList<ListNode> res = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();

        treeNodes.offer(tree);
        ListNode dummy = new ListNode(0);
        while (!treeNodes.isEmpty()) {
            int curLine = treeNodes.size();
            ListNode p = dummy;
            for (int i = 0; i < curLine; i++) {
                TreeNode poll = treeNodes.poll();
                p.next = new ListNode(poll.val);
                p = p.next;
                if (poll.left != null) {
                    treeNodes.offer(poll.left);
                }
                if (poll.right != null) {
                    treeNodes.offer(poll.right);
                }
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        return res.toArray(new ListNode[] {});
    }
}
