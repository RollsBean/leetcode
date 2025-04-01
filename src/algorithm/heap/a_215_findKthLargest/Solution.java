package algorithm.heap.a_215_findKthLargest;


/**
 * 215-数组中的第K个最大元素
 * <p/>
 * @see <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">
 *  https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * </a>
 * @author 景行
 * @date 2021/06/06
 **/
public class Solution {

    Node<Integer> head = null;
    Node<Integer> tail = null;

    /**
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 && k == 1) return nums[0];
        // 思路：构造一个长度为k的链表,按顺序保持k个元素，超过就把最小的弹出
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (size < k) {
                if (size == 0) {
                    head = new Node<>(null, num, null);
                    tail = head;
                    size++;
                } else {
                    if (num >= head.val) {
                        head = new Node<>(head, num, null);
                        head.prev.next = head;
                        size++;
                    } else {
                        if (tail != null && tail.val < num) {
                            // 递归找
                            insert(tail.next, num, size);
                        } else {
                            if (tail == null) {
                                tail = new Node<>(null, num, head);
                                head.prev = tail;
                            } else {
                                tail = new Node<>(null, num, tail);
                                tail.next.prev = tail;
                            }
                        }
                    }
                }
            } else if (tail != null && tail.val < num){
                // 递归找
                insert(tail, num, size);
            }
        }
        return getK(head, k, 1);
    }

    private int getK(Node<Integer> head, int k, int i) {
        int kVal = 0;
        if (k != i) {
            kVal = getK(head.prev, k, ++i);
        } else {
            kVal = head.val;
        }
        return kVal;
    }

    private int insert(Node<Integer> next, int num, int size) {
        if (next.val < num) {
            if (next.next == null) {
                head = new Node<>(head, num, null);
                next.next = head;
                size++;
            } else {
                insert(next.next, num, size);
            }
        } else {
            Node<Integer> node = new Node<>(next.prev, num, next);
            next.prev = node;
            node.prev.next = node;
            size++;
        }
        return size;
    }


    public class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        public Node() {
        }

        Node(Node<E> prev, E val, Node<E> next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        int[] ints = {5,2,4,1,3,6,0};
        Solution solution = new Solution();
        int k = solution.findKthLargest(ints, 4);
        System.out.println(k);
    }
}
