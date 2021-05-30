package a_2_addTwoNumbers;

/**
 * @description:
 * @author: 景行
 * @create: 2021/02/27
 **/
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

    @Override
    public String toString() {
        return "addTwoNumbers_2.ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
