package algorithm.string.a_2_addTwoNumbers;

import algorithm.ListNode;

/**
 * 两数相加
 * <p/>
 * 难度：中等
 * @author: 景行
 * @create: 2021/02/26
 **/
class SumTwoNumbers {

    /**
     * 题目：
     * <p/>
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * <br/>
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * <br/>
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p/>
     * 思路:
     * <p/>
     * 从左向右加，大于10进位，一个链表的值为null另一个不为null时，默认为null的值为0
     *
     * 来源：力扣（LeetCode）
     * 链接：@see <a href="https://leetcode-cn.com/problems/add-two-numbers">https://leetcode-cn.com/problems/add-two-numbers</a>
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        int count = 1;
        int val1 = l1.val;
        int val2 = l2.val;

        if (val1 > 10 || val1 < 0 || val2 > 10 || val2 < 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode next1 = l1;
        ListNode next2 = l2;
        int decade = 10;
        // 是否进位
        boolean isDec = false;
        boolean l1End = false;
        boolean l2End = false;
        ListNode temp = new ListNode(0);
        do {
            if (next1 != null) {
                val1 = next1.val;
            } else {
                val1 = 0;
                l1End = true;
            }
            if (next2 != null) {
                val2 = next2.val;
            } else {
                val2 = 0;
                l2End = true;
            }
            if (l1End && l2End) {
                if (isDec) {
                    temp.next = new ListNode(1);
                }
                return result;
            }
            int sum = val1 + val2;
            if (isDec) {
                //进位
                sum++;
            }
            if (sum >= decade) {
                isDec = true;
                sum -= decade;
            } else {
                isDec = false;
            }

            if (count == 1) {
                result.val=sum;
                temp = result;
            } else {
                temp = new ListNode(sum);
            }

            if(next1!=null) {
                next1 = next1.next;
            }
            if (next2!=null){
                next2 = next2.next;
            }
            count++;
        } while (true);
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        addTwoNumbers_2.ListNode l1 = new addTwoNumbers_2.ListNode(0);
//        addTwoNumbers_2.ListNode l2 = new addTwoNumbers_2.ListNode(0);

//        addTwoNumbers_2.ListNode l1 = new addTwoNumbers_2.ListNode(1);
//        l1.next = new addTwoNumbers_2.ListNode(8);
//        addTwoNumbers_2.ListNode l2 = new addTwoNumbers_2.ListNode(0);
        SumTwoNumbers sumTwoNumbers = new SumTwoNumbers();
        ListNode result = sumTwoNumbers.addTwoNumbers(l1, l2);
        while (true) {
            if (result != null) {
                System.out.print(result.val+",");
                result = result.next;
            } else {
                return;
            }
        }
    }
}
