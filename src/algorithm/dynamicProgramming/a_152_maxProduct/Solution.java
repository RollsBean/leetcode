package algorithm.dynamicProgramming.a_152_maxProduct;

/**
 * 152. 乘积最大子数组
 */
class Solution {
    public int maxProduct(int[] nums) {
        // 1. 定义 dp 数组，dp[i] 是以 nums[i] 结尾的数组最大乘积，但是考虑正负的问题，需要两个 dp 数组，最大正数和最大负数乘积
        // 2. 递推公式：minDp[i] = dp[i-1] *
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        int maxPositive = maxDp[0];
        for (int i = 1; i < nums.length; i++) {
            int a = nums[i]*minDp[i-1];
            int b = nums[i]*maxDp[i-1];
            if (a >= b) {
                if (nums[i] > a) {
                    maxDp[i] = nums[i];
                } else {
                    maxDp[i] = a;
                }
                if (nums[i] < b) {
                    minDp[i] = nums[i];
                } else {
                    minDp[i] = b;
                }
            } else {
                if (nums[i] > b) {
                    maxDp[i] = nums[i];
                } else {
                    maxDp[i] = b;
                }
                if (nums[i] < a) {
                    minDp[i] = nums[i];
                } else {
                    minDp[i] = a;
                }
            }
            maxPositive = Math.max(maxPositive, maxDp[i]);
        }
        return maxPositive;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{-2};
        int max = solution.maxProduct(nums);
        System.out.println(max);
    }
}
