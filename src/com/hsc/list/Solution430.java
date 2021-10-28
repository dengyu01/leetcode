package com.hsc.list;

public class Solution430 {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        // 设置哨兵节点
        Node res = new Node(-1);
        dfs(head, res);
        // 让头节点的前指针指向null
        res.next.prev = null;
        return res.next;
    }

    public Node dfs(Node head, Node res) {
        Node temp = head;
        // cur节点指向当前已扁平化列表的最后一个节点
        Node cur = res;
        while (head != null) {
            // temp指向当前遍历到的节点，head移动到下一个节点
            temp = head;
            head = head.next;

            // 当前节点加入扁平化列表，移动cur节点
            cur.next = temp;
            temp.prev = cur;
            cur = cur.next;

            // 深度优先遍历
            if (temp.child != null) {
                cur = dfs(temp.child, cur);
                temp.child = null;
            }
        }
        return cur;
    }
}
