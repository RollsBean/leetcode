package algorithm.linkedList.a_206_reverseList;

import algorithm.ListNode;

/**
 * 双指针，记录 prev 节点，循环到最后一个节点设置 cur.next = pre 即可
 */
class Solution206_2 {

    public ListNode reverseList(ListNode head) {
        // 双指针 当前节点 头节点
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;

        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;

        return cur;
    }

    public static void main(String[] args) {
        Solution206_2 solution = new Solution206_2();
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode listNode = solution.reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}
