package a_27_removeElement;

public class Solution {

    /**
     * 双指针，快指针 read，慢指针 write，只要元素不等于 val 就给慢指针对应的元素赋值，read >= write
     * @param nums
     * @param val
     * @return 返回数组 nums 中不等 val 的元素数量
     */
    public int removeElement(int[] nums, int val) {
        int write = 0;
        for(int read = 0; read < nums.length; read++) {
            if (nums[read] != val) {
                if (read != write) {
                    nums[write++] = nums[read];
                } else {
                    write++;
                }
            }
        }
        return write;
    }
}
