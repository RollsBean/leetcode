package algorithm.array.a_21_mergeSortedList;

import algorithm.ListNode;

/**
 * 21-合并两个有序链表
 * <p/>
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">
 *     https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *     </a>
 *
 * @author 景行
 * @date 2021/05/11
 **/
public class Solution21 {

    /**
     * 题目：
     * <p/>
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p/>
     * <blockquote> 示例1
     * <pre>
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * </pre>
     * </blockquote>
     * <blockquote> 示例2
     * <pre>
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * </pre>
     * </blockquote>
     * <blockquote> 示例2
     * <pre>
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * </pre>
     * </blockquote>
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 合并后新的升序列表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        // 最终合并的列表头节点
        ListNode mergedList = null;

        if (l1.val <= l2.val) {
            mergedList = l1;
            l1 = l1.next;
        } else {
            mergedList = l2;
            l2 = l2.next;
        }
        // 最终合并列表的滑动指针，每合并一个节点，就向前移动一次
        ListNode mergedCur = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergedCur.next = l1;
                l1 = l1.next;
            } else {
                mergedCur.next = l2;
                l2 = l2.next;
            }
            mergedCur = mergedCur.next;
        }
        if (l1 == null) {
            mergedCur.next = l2;
        } else {
            mergedCur.next = l1;
        }
        return mergedList;
    }

    public static void main(String[] args) {
//        test3();
        test3();
        System.out.println("ok");
    }

    private static void test1() {
        Solution21 solution21 = new Solution21();
        ListNode l3 = new ListNode(7);
        ListNode l2 = new ListNode(5, l3);
        ListNode l1 = new ListNode(4, l2);

        ListNode r3 = new ListNode(6);
        ListNode r2 = new ListNode(4, r3);
        ListNode r1 = new ListNode(2, r2);
        ListNode mergedList = solution21.mergeTwoLists(l1, r1);
    }

    private static void test2() {
        Solution21 solution21 = new Solution21();
        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode r3 = new ListNode(4);
        ListNode r2 = new ListNode(3, r3);
        ListNode r1 = new ListNode(1, r2);
        ListNode mergedList = solution21.mergeTwoLists(l1, r1);
    }

    private static void test3() {
        Solution21 solution21 = new Solution21();
        ListNode l1 = new ListNode(1);

        ListNode r1 = new ListNode(2);
        ListNode mergedList = solution21.mergeTwoLists(l1, r1);
    }

}
