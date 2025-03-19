package a_141_hasCycle;

import b_listBean.ListNode;

import java.util.HashSet;

public class Solution {
    /**
     * 暴力解
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        HashSet<ListNode> set = new HashSet();
        set.add(head);
        while (head.next != null) {
            if (set.contains(head.next)) {
                return true;
            } else {
                set.add(head.next);
                head = head.next;
            }
        }
        return false;
    }


    /**
     * 双指针 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle_optimize(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        if (head.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            while (true) {
                if (fast == slow) {
                    return true;
                }
                if (slow.next != null && fast.next != null && fast.next.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
