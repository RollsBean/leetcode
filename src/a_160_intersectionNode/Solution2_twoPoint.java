package a_160_intersectionNode;

import b_listBean.ListNode;

public class Solution2_twoPoint {

    /**
     * 双指针，如果链表 a = a1 + c,其中 a1 是不相交的部分，c 是相交部分， 链表 b = b1 + c，b1 是链表 b 不相交部分<br/>
     * 可得 (a1 + c) + b1 = (b1 +c) + a1 即 a + b1 = b + a1，如果相交，走相同步长一定相遇
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);

        ListNode headB = new ListNode(1);
        headB.next = headA.next.next;
        Solution2_twoPoint solution = new Solution2_twoPoint();
        ListNode intersectionNode = solution.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }
}
