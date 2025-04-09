package algorithm.linkedList.a_25_reverseKGroup;

import algorithm.ListNode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 25:K 个一组反转链表
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        // 递归
        // 反转前头节点
        ListNode current = head;
        ListNode newHead = null;
        // 外层 prev
        ListNode outerPrev  = null;
        // 内层反转后的 tail
        AtomicReference<ListNode> innerTail = new AtomicReference<>();
        // 外层 next
        AtomicReference<ListNode> outerNext = new AtomicReference<>();
        // k <= n
        AtomicInteger reverseCount = new AtomicInteger(0);
        while (current != null) {
            // 内层
            ListNode innerPrev = null;
            // 1 2 3 4 5
            AtomicInteger count = new AtomicInteger(k);

            recursiveReverse(current, innerTail, innerPrev, count, outerNext);
            // 外层 next
            // 有反转
            if (count.get() == 0) {
                if (outerPrev != null) {
                    outerPrev.next = innerTail.get();
                }
                outerPrev = current;
                current.next = outerNext.get();
            }

            int reverseCnt = reverseCount.incrementAndGet();
            if (reverseCnt == 1) {
                newHead = innerTail.get();
            }

            // 重置
            current = outerNext.get();
            innerTail.set(null);
            outerNext.set(null);
        }
        return newHead;
    }

    /**
     *
     * @param current
     * @param innerTail 内层反转后 tail
     * @param innerPrev 内层反转前的 prev
     * @param count
     * @param outerNext 外层 next
     */
    private void recursiveReverse(ListNode current, AtomicReference<ListNode> innerTail, ListNode innerPrev,
                                  AtomicInteger count, AtomicReference<ListNode> outerNext) {
        if (current == null) {
            // 不反转
            return;
        }
        if (count.decrementAndGet() == 0) {
            innerTail.set(current);
            ListNode next = current.next;
            outerNext.set(next);
            current.next = innerPrev;
            return;
        }
        recursiveReverse(current.next, innerTail, current, count, outerNext);
        // 2->3
        if (count.get() == 0) {
            current.next = innerPrev;
        } else {
            outerNext.set(null);
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode listNode = solution.reverseKGroup(head, 3);
        System.out.println(listNode);
    }
}
