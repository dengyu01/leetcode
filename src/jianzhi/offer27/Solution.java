package jianzhi.offer27;

import com.hsc.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode res = new TreeNode(root.val);
        deque1.offer(root);
        stack.offer(res);
        while (!deque1.isEmpty()) {
            TreeNode poll = deque1.poll();
            TreeNode cur = stack.poll();
            if (poll.left != null) {
                TreeNode treeNode = new TreeNode(poll.left.val);
                cur.right = treeNode;
                stack.offer(treeNode);
                deque1.offer(poll.left);
            }
            if (poll.right != null) {
                TreeNode treeNode = new TreeNode(poll.right.val);
                cur.left = treeNode;
                stack.offer(treeNode);
                deque1.offer(poll.right);
            }
        }
        return res;
    }
}
