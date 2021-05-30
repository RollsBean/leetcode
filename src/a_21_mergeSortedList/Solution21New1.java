package a_21_mergeSortedList;

/**
 * @author 景行
 * @date 2021/05/16
 **/
public class Solution21New1 {

    /**
     * 思路：递归的方式求解
     * <p/>
     * 比如：l1 [1,2,4] 和 l2 [1,3,4] 合并，等同于1和 链表[2,4] [1,3,4]的结果合并，就是取出最小的节点，然后将剩余的链表合并，
     * 如上就是比较l1和l2的头节点，将最小的取出，比如将l1的头节点取出，生成新的l1 [2,4]，只要将剩余的链表合并，即可得出新的链表。
     * <blockquote>
     *     递归如下:
     *     <pre>
     * l1 [1,2,4] 和 l2 [1,3,4]， 等同于 1 和 链表[2,4] [1,3,4]的结果合并， 1的next就是新合并的链表
     * 链表[2,4] [1,3,4] 合并又等同于 1 和 [2,4] [3,4] 合并，依次类推，直到最终链表没有next为止（递归终止条件）。
     *
     * [1,2,4] [1,3,4] => 1 -> [2,4] [1,3,4]
     * [2,4] [1,3,4] => 1 -> [2,4] [3,4]
     * [2,4] [3,4] => 2 -> [4] [3,4]
     * [4] [3,4]   => 3 -> [4] [4]
     * [4] [4]     => 4 -> [] [4]
     *     </pre>
     * </blockquote>
     * 思路：递归实现，比较l1和l2的头节点大小并赋值给head 对象，这时head指向的就是l1或者l2的地址
     * <br/>
     * 比如：
     * <blockquote>
     * 如果<code>l1.val&lt;l2.val</code>
     * <br/>
     * 则 <code>head = l1</code>，<br/>
     * 接下来再比较 l1.next和 l2即可，即比较 head.next 和 l2 <br/>
     * 也就是如下代码: <br/>
     * <code>mergeTwoLists(he/ad.next, l1.val < l2.val ? l2 : l1);</code> <br/>
     * 递归出栈时就返回了最开始的头节点 head <br/>
     * </blockquote>
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = l1.val < l2.val ? l1 : l2;
        head.next = mergeTwoLists(head.next, l1.val < l2.val ? l2 : l1);
        return head;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        Solution21New1 solution21 = new Solution21New1();
        Solution21New1.ListNode l3 = solution21.new ListNode(4);
        Solution21New1.ListNode l2 = solution21.new ListNode(2, l3);
        Solution21New1.ListNode l1 = solution21.new ListNode(1, l2);

        Solution21New1.ListNode r3 = solution21.new ListNode(4);
        Solution21New1.ListNode r2 = solution21.new ListNode(3, r3);
        Solution21New1.ListNode r1 = solution21.new ListNode(1, r2);
        Solution21New1.ListNode mergedList = solution21.mergeTwoLists(l1, r1);
    }
}
