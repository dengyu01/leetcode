package jianzhi.offer06;

class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode flag = new ListNode(-1);
        ListNode pre = flag;
        ListNode cur = head;
        ListNode next;
        int n = 0;
        while (cur != null) {
            n ++;
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        int[] res = new int[n];
        int i = 0;
        while (i < n) {
            res[i] = pre.val;
            i ++;
            pre = pre.next;
        }
        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}