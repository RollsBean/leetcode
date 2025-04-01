package algorithm.stack.a_234_isPalindrome;

import algorithm.ListNode;

import java.util.ArrayDeque;

/**
 * 是否是回文链表
 */
public class Solution {

    /**
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<ListNode> stack = new ArrayDeque<>();
        ListNode pivot = head;
        while (pivot != null) {
            stack.push(pivot);
            pivot = pivot.next;
        }
        while (head != null) {
            ListNode pop = stack.pop();
            if (head.val != pop.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);

        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
    }
}
