package a_206_reverseList;

/**
 * @author 景行
 * @date 2021/05/30
 **/
public class Solution206 {

    /**
     * 反转链表
     * <br/>
     * 递归实现
     * <blockquote>
     *     <pre>
     * 1->3->4->5
     * 1->3->4<-5
     * 如上，此时进行到节点3，需要反转3和4，3.next就是4，4.next就是3
     * 也就是 3.next.next = 3，这样4就指向了3
     *     </pre>
     * </blockquote>
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode next = reverseList(head.next);
        // 如何返回反转后的链表头是关键
        head.next.next = head;
        head.next = null;
        return next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Solution206 solution = new Solution206();

        ListNode l3 = solution.new ListNode(3);
        ListNode l2 = solution.new ListNode(2, l3);
        ListNode l1 = solution.new ListNode(1, l2);
        ListNode listNode = solution.reverseList(l1);
    }
}
