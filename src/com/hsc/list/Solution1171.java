package com.hsc.list;

import com.hsc.bean.ListNode;

import java.util.HashMap;
import java.util.Map;

public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode p = dummy; p != null ; p = p.next) {
            sum += p.val;
            map.put(sum, p);
        }

        sum = 0;
        for(ListNode p = dummy; p != null; p = p.next) {
            sum += p.val;
            p.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
