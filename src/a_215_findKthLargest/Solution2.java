package a_215_findKthLargest;

import java.util.PriorityQueue;

public class Solution2 {

    public static void main(String[] args) {
        int kthLargest = Solution2.findKthLargest(new int[]{1,2,5,4,3}, 3);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
