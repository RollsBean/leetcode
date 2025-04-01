package algorithm.dynamicProgramming.a_198_rob;

/**
 * 198-打家劫舍
 */
public class Solution {
    /**
     * 空间复杂度 O(N)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        int[] dp = new int[nums.length];

        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];

        if (length == 3) {
            dp[2] = nums[0] + nums[2];
            return Math.max(dp[1], dp[2]);
        }
        dp[2] = nums[0] + nums[2];
        int max = Math.max(dp[1], dp[2]);
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            max = Math.max(dp[i], dp[i - 1]);
        }
        return max;
    }

    /**
     * 空间复杂度 O(1) 算法
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int length = nums.length;
        // 状态方程是： f(i) = max(f(i-1), f(i-2) + nums[i])
        int curr = 0;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(first + nums[i], second);
            first = second;
            second = curr;
        }
        return Math.max(first, second);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.rob1(new int[]{4,1,2,7,5,3,1});
        System.out.printf("最大值： " + i);
    }
}
