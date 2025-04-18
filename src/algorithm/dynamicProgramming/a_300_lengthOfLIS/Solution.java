package algorithm.dynamicProgramming.a_300_lengthOfLIS;

import java.util.Arrays;

/**
 * 300. 最长递增子序列
 * <p>示例 1：<pre>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * </pre>
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 思路：先计算一遍有哪些连续递增子序列，然后依次计算
        // 官方题解：定义 dp[i] 是以 nums[i] 结尾的最长递增序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            // 转移方程 if nums[i] > nums[j],j<i  dp[i] = max(dp[j]) + 1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int i = solution.lengthOfLIS(nums);
        System.out.println(i);
    }
}
