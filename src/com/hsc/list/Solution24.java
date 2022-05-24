package com.hsc.list;

import com.hsc.bean.ListNode;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode flag = new ListNode(-1);
        flag.next = head;

        ListNode one = null, two = null;

        ListNode cur = flag;
        while (true) {
            one = cur.next;
            if (one == null || one.next == null) {
                break;
            }
            two = one.next;
            ListNode next = two.next;

            two.next = one;
            cur.next = two;
            one.next = next;

            cur = one;
        }
        return flag.next;
    }
}
