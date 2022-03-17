package jianzhi.offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> layer = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    temp.offer(node.left);
                }
                if (node.right != null) {
                    temp.offer(node.right);
                }
            }
            res.add(layer);
            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        solution2.levelOrder(node1);
    }
}
