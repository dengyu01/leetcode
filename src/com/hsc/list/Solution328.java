package com.hsc.list;

import com.hsc.bean.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode pre = head.next;
        ListNode temp = pre.next;
        ListNode insert = head;
        while (temp != null) {
            pre.next = temp.next;
            temp.next = insert.next;
            insert.next = temp;
            insert = temp;

            if (pre.next == null || pre.next.next == null) {
                break;
            }
            pre = pre.next;
            temp = pre.next;
        }
        return head;
    }
}
