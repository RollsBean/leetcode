package algorithm.linkedList.a_24_swapPairs;

import algorithm.ListNode;

/**
 * 24:两两交换链表中的节点
 */
class Solution {

    /**
     * 指针两两交换即可
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode first = head;
        ListNode prev = null;
        while (first != null && first.next != null) {
            ListNode second = first.next;
            if (prev == null) {
                newHead = second;
            }
            // [ 5,2,4,3,2,6,2 ]
            // swap
            ListNode next = second.next;
            first.next = next;
            second.next = first;
            if (prev != null) {
                prev.next = second;
            }
            prev = first;

            first = next;
        }

        return newHead;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        Solution solution = new Solution();
        ListNode x = solution.swapPairs(head);
        System.out.println(x);
    }
}
