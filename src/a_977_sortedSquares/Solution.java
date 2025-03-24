package a_977_sortedSquares;

public class Solution {

    /**
     * 先找到最低点，也就是正负交界的位置，然后两个指针依次 set 较小值到新数组中，需要
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        if (nums.length == 1) {
            nums[0] *= nums[0];
            return nums;
        }
        int pivot = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < 0 && nums[i+1] >= 0) {
                pivot = i+1;
                break;
            }
        }
        int leftIdx = pivot - 1;
        int rightIdx = pivot;
        int[] squares = new int[nums.length];
        int startIdx = 0;
        // 单调
        /*if (pivot < 0) {
            if (nums[0] < 0) {
                for (int i = 0; i < nums.length; i++) {
                    squares[i] = nums[nums.length - i - 1]*nums[nums.length - i - 1];
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    squares[i] = nums[i]*nums[i];
                }
            }
            return squares;
        }*/
        int leftSquare = 0;
        int rightSquare = 0;
        while (startIdx < nums.length) {
            if (leftSquare >= rightSquare && rightIdx < nums.length) {
                leftSquare = leftIdx >= 0 ? nums[leftIdx]*nums[leftIdx] : leftSquare;
                rightSquare = nums[rightIdx]*nums[rightIdx];
                squares[startIdx] = rightSquare;
                rightIdx++;
            } else {
                if (leftIdx >= 0) {
                    leftSquare = nums[leftIdx]*nums[leftIdx];
                    rightSquare = rightIdx < nums.length ? nums[rightIdx]*nums[rightIdx] : rightSquare;
                    squares[startIdx] = leftSquare;
                    leftIdx--;
                } else {
                    rightSquare = rightIdx < nums.length ? nums[rightIdx]*nums[rightIdx] : rightSquare;
                    squares[startIdx] = rightSquare;
                    rightIdx++;
                }
            }
            startIdx++;
        }
        return squares;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 2};
        int[] ints = solution.sortedSquares(nums);
    }
}
