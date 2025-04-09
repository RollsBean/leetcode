package algorithm.linkedList.a_160_intersectionNode;

import algorithm.ListNode;

class Solution {
    /**
     * 计算两个链表长度，对齐长度依次遍历
     * @param headA 不为空
     * @param headB 不为空
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = recursiveCnt(headA);
        int countB = recursiveCnt(headB);
        if (countA >= countB) {
            int diff = countA - countB;
            while (diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = countB - countA;
            while (diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            if (headA.next == null) {
                return null;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int recursiveCnt(ListNode node) {
       if (node == null) {
           return 0;
       }
       return recursiveCnt(node.next) + 1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution solution = new Solution();
        int i = solution.recursiveCnt(head);
        System.out.println(i);
    }
}
