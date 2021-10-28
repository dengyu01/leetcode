package com.hsc.list;

import com.hsc.bean.ListNode;

public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode i = head;
        while (i != null) {
            len++;
            i = i.next;
        }
        int perLen = len / k;
        int rest = len % k;
        i = head;
        ListNode[] res = new ListNode[k];
        int index = 0;
        ListNode pre;
        while (i != null) {
            ListNode cur = new ListNode(-1);
            pre = cur;
            cur.next = i;
            int j = perLen;
            while (j-- > 0) {
                pre = i;
                i = i.next;
            }
            if (rest-- > 0) {
                pre = i;
                i = i.next;
            }
            pre.next = null;
            res[index++] = cur.next;
        }
        return res;
    }
}
