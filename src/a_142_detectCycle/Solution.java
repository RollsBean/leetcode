package a_142_detectCycle;

import b_listBean.ListNode;

public class Solution {

    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pivot = null;
        if (head.next == null || head.next.next == null) {
            return null;
        }


        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                pivot = slow;
                break;
            }
        }
        if (pivot != null) {
            while (pivot != head) {
                pivot = pivot.next;
                head = head.next;
            }
            return pivot;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        solution.detectCycle(head);
    }
}
