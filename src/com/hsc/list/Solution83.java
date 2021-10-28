package com.hsc.list;

import com.hsc.bean.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head, q;
        while (p != null) {
            int curVal = p.val;
            q = p;
            while (q != null && q.val == curVal) {
                q = q.next;
            }
            if (q != p) {
                p.next = q;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
