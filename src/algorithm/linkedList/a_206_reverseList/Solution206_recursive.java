package algorithm.linkedList.a_206_reverseList;

import algorithm.ListNode;

/**
 * 递归
 */
class Solution206_recursive {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        recursive(head, newHead);
        return newHead.next;
    }

    private ListNode recursive(ListNode head, ListNode newHead) {
        if (head.next == null) {
            newHead.next = head;
            return head;
        }
        ListNode cur = recursive(head.next,newHead);
        cur.next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        ListNode listNode = new Solution206_recursive().reverseList(head);

    }

}
