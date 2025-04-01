package algorithm.linkedList.a_21_removeNthFromEnd;

import algorithm.ListNode;

import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        ListNode listNode = new ListNode(0, head);
        recursiveGetNthNode(listNode, n, atomicInteger);
        return listNode.next;
    }

    private void recursiveGetNthNode(ListNode head, int n, AtomicInteger count) {
        if (head != null) {
            recursiveGetNthNode(head.next, n, count);
            int c = count.incrementAndGet();
            if (n == c-1) {
                if (head.next == null) {

                }
                head.next = head.next.next;
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode x = solution.removeNthFromEnd(head, 1);
        System.out.println(x);
    }
}
